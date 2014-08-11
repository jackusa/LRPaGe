
package bepler.lrpage.ebnf.parser.nodes;

import bepler.lrpage.ebnf.parser.Visitor;


/**
 * This class was generated by the LRPaGe parser generator v1.0 using the com.sun.codemodel library.
 * 
 * <P>LRPaGe is available from https://github.com/tbepler/LRPaGe.
 * <P>CodeModel is available from https://codemodel.java.net/.
 * 
 */
public class BothDirective
    extends DirectiveAbstractNode
{

    public final AssocAbstractNode assoc0;
    public final IntToken int1;
    public final SymbolListAbstractNode symbollist2;

    public BothDirective(AssocAbstractNode assoc0, IntToken int1, SymbolListAbstractNode symbollist2, TerminationToken termination3) {
        this.assoc0 = assoc0;
        this.int1 = int1;
        this.symbollist2 = symbollist2;
    }

    @Override
    public int getLine() {
        return assoc0 .getLine();
    }

    @Override
    public int getPos() {
        return assoc0 .getPos();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = ((hash* 13)+ assoc0 .hashCode());
        hash = ((hash* 13)+ int1 .hashCode());
        hash = ((hash* 13)+ symbollist2 .hashCode());
        hash = ((hash* 13)+ getClass().hashCode());
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
        if (!(o instanceof BothDirective)) {
            return false;
        }
        BothDirective castResult = ((BothDirective) o);
        if (!this.assoc0 .equals(castResult.assoc0)) {
            return false;
        }
        if (!this.int1 .equals(castResult.int1)) {
            return false;
        }
        if (!this.symbollist2 .equals(castResult.symbollist2)) {
            return false;
        }
        return true;
    }

}
