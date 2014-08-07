
package bepler.lrpage.ebnf.parser.nodes;

import bepler.lrpage.ebnf.parser.Visitor;


/**
 * This class was generated by the LRPaGe parser generator v1.0 using the com.sun.codemodel library.
 * 
 * <P>LRPaGe is available from https://github.com/tbepler/LRPaGe.
 * <P>CodeModel is available from https://codemodel.java.net/.
 * 
 */
public class SymbolRHS
    extends RHSAbstractNode
{

    public final SymbolAbstractNode symbol0;

    public SymbolRHS(SymbolAbstractNode symbol0) {
        this.symbol0 = symbol0;
    }

    @Override
    public int getLine() {
        return symbol0 .getLine();
    }

    @Override
    public int getPos() {
        return symbol0 .getPos();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = (hash*(13 + symbol0 .hashCode()));
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this.equals(o)) {
            return true;
        }
        if (o.equals(null)) {
            return false;
        }
        if (!(o instanceof SymbolRHS)) {
            return false;
        }
        SymbolRHS castResult = ((SymbolRHS) o);
        if (!this.symbol0 .equals(castResult.symbol0)) {
            return false;
        }
        return true;
    }

}
