package bepler.lrpage.code.generator;

import java.io.File;
import java.io.IOException;

import bepler.lrpage.grammar.Grammar;
import bepler.lrpage.grammar.Terminal;

import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JVar;

public class CodeGenerator {
	
	private static final String REPLACE = "replace";
	private static final String TYPE = "type";
	private static final String ACCEPT = "accept";
	private static final String VISITOR = "Visitor";
	private static final String ABSTRACT_SYNTAX_NODE = "AbstractSyntaxNode";
	private static final String EOF_TOKEN = "EOFToken";
	private static final String EOF = "EOF";
	private static final String SYMBOLS = "Symbols";
	
	private final JCodeModel model = new JCodeModel();
	private final JDefinedClass iVisitor;
	private final JDefinedClass symbolsEnum;
	private final JDefinedClass syntaxNode;
	private final JDefinedClass eofToken;
	
	private final LexerGenerator lexerGen;
	
	public CodeGenerator(String name, Grammar g){
		try {
			iVisitor = model._class(VISITOR, ClassType.INTERFACE);
			symbolsEnum = model._class(SYMBOLS, ClassType.ENUM);
			syntaxNode = model._class(ABSTRACT_SYNTAX_NODE, ClassType.INTERFACE);
			JMethod accept = syntaxNode.method(JMod.PUBLIC, void.class , ACCEPT);
			accept.param(iVisitor, "visitor");
			syntaxNode.method(JMod.PUBLIC, symbolsEnum, TYPE);
			syntaxNode.method(JMod.PUBLIC, syntaxNode, REPLACE);
			eofToken = this.initEOFToken();
			
			lexerGen = new LexerGenerator(name, model, syntaxNode, eofToken);
			MainGenerator.generateMain(null, model, lexerGen.getLexerClass());
			
			for(Terminal t : g.getTokens()){
				this.addToken(t);
			}
			
		} catch (JClassAlreadyExistsException e) {
			throw new RuntimeException(e);
		}
	}
	
	private JDefinedClass initEOFToken() throws JClassAlreadyExistsException{
		JDefinedClass eofToken = model._class(EOF_TOKEN)._implements(syntaxNode);
		
		//override accept method
		JMethod accept = eofToken.method(JMod.PUBLIC, void.class, ACCEPT);
		accept.param(iVisitor, "visitor");
		accept.annotate(Override.class);
		accept.body().directStatement("//do nothing");
		
		//override type method
		JMethod type = eofToken.method(JMod.PUBLIC, symbolsEnum, TYPE);
		type.annotate(Override.class);
		type.body()._return(symbolsEnum.enumConstant(EOF));
		
		//override toString method
		JMethod toString = eofToken.method(JMod.PUBLIC, String.class, "toString");
		toString.annotate(Override.class);
		toString.body()._return(JExpr.invoke(JExpr.invoke(JExpr._this(), type), "toString"));
		
		return eofToken;
	}
	
	public void write(File dir) throws IOException{
		model.build(dir);
	}
	
	private void addToken(Terminal t) throws JClassAlreadyExistsException{
		JDefinedClass node;
		if(t.getSymbol() != null){
			node = model._class(t.getSymbol()+"Token")._implements(syntaxNode);
			JVar text = node.field(JMod.PUBLIC+JMod.FINAL, String.class, "text");
			JVar line = node.field(JMod.PUBLIC+JMod.FINAL, int.class, "line");
			JVar pos = node.field(JMod.PUBLIC+JMod.FINAL, int.class, "pos");
			JMethod cons = node.constructor(JMod.PUBLIC);
			cons.body().assign(JExpr._this().ref(text), cons.param(String.class, "text"));
			cons.body().assign(JExpr._this().ref(line), cons.param(int.class, "line"));
			cons.body().assign(JExpr._this().ref(pos), cons.param(int.class, "pos"));
			JMethod visit = this.addVisitableNode(node);
			//override accept method
			JMethod accept = node.method(JMod.PUBLIC, void.class, ACCEPT);
			accept.annotate(Override.class);
			accept.body().invoke(accept.param(iVisitor, "visitor"), visit).arg(JExpr._this());
			//override type method
			JMethod type = node.method(JMod.PUBLIC, symbolsEnum, TYPE);
			type.annotate(Override.class);
			type.body()._return(symbolsEnum.enumConstant(t.getSymbol()));
			//define toString() for this class
			JMethod toString = node.method(JMod.PUBLIC, String.class, "toString");
			toString.annotate(Override.class);
			toString.body()._return(JExpr.invoke(JExpr._this(), type)
					.plus(JExpr.lit("("))
					.plus(text)
					.plus(JExpr.lit(", "))
					.plus(line)
					.plus(JExpr.lit(":"))
					.plus(pos)
					.plus(JExpr.lit(")")));
		}else{
			node = null;
		}
		
		//add to lexer generator
		lexerGen.addTerminal(t.getRegex(), node);
	}
	
	private JMethod addVisitableNode(JDefinedClass node){
		JMethod visit = iVisitor.method(JMod.PUBLIC, void.class, "visit");
		visit.param(node, "node");
		
		return visit;
	}

}