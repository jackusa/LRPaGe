
package bepler.lrpage.ebnf.parser.nodes;

import bepler.lrpage.ebnf.parser.Visitor;


/**
 * This class was generated by the LRPaGe parser generator v1.0 using the com.sun.codemodel library.
 * 
 * <P>LRPaGe is available from https://github.com/tbepler/LRPaGe.
 * <P>CodeModel is available from https://codemodel.java.net/.
 * 
 */
public class LitSymbol
    extends SymbolAbstractNode
{

    public final TerminalStringToken terminalstring0;

    public LitSymbol(TerminalStringToken terminalstring0) {
        this.terminalstring0 = terminalstring0;
    }

    @Override
    public int getLine() {
        return terminalstring0 .getLine();
    }

    @Override
    public int getPos() {
        return terminalstring0 .getPos();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = ((hash* 13)+ terminalstring0 .hashCode());
        hash = ((hash* 13)+ getClass().hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (null == o) {
            return false;
        }
        if (!(o instanceof LitSymbol)) {
            return false;
        }
        LitSymbol castResult = ((LitSymbol) o);
        if (!this.terminalstring0 .equals(castResult.terminalstring0)) {
            return false;
        }
        return true;
    }

}
