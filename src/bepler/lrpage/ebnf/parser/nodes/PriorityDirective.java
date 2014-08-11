
package bepler.lrpage.ebnf.parser.nodes;

import bepler.lrpage.ebnf.parser.Visitor;


/**
 * This class was generated by the LRPaGe parser generator v1.0 using the com.sun.codemodel library.
 * 
 * <P>LRPaGe is available from https://github.com/tbepler/LRPaGe.
 * <P>CodeModel is available from https://codemodel.java.net/.
 * 
 */
public class PriorityDirective
    extends DirectiveAbstractNode
{

    public final IntToken int0;
    public final SymbolListAbstractNode symbollist1;

    public PriorityDirective(IntToken int0, SymbolListAbstractNode symbollist1, TerminationToken termination2) {
        this.int0 = int0;
        this.symbollist1 = symbollist1;
    }

    @Override
    public int getLine() {
        return int0 .getLine();
    }

    @Override
    public int getPos() {
        return int0 .getPos();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = ((hash* 13)+ int0 .hashCode());
        hash = ((hash* 13)+ symbollist1 .hashCode());
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
        if (!(o instanceof PriorityDirective)) {
            return false;
        }
        PriorityDirective castResult = ((PriorityDirective) o);
        if (!this.int0 .equals(castResult.int0)) {
            return false;
        }
        if (!this.symbollist1 .equals(castResult.symbollist1)) {
            return false;
        }
        return true;
    }

}
