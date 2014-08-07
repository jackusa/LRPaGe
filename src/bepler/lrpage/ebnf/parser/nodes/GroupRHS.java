
package bepler.lrpage.ebnf.parser.nodes;

import bepler.lrpage.ebnf.parser.Visitor;


/**
 * This class was generated by the LRPaGe parser generator v1.0 using the com.sun.codemodel library.
 * 
 * <P>LRPaGe is available from https://github.com/tbepler/LRPaGe.
 * <P>CodeModel is available from https://codemodel.java.net/.
 * 
 */
public class GroupRHS
    extends RHSAbstractNode
{

    public final RHSAbstractNode rhs0;

    public GroupRHS(StartGroupingToken startgrouping0, RHSAbstractNode rhs1, EndGroupingToken endgrouping2) {
        this.rhs0 = rhs1;
    }

    @Override
    public int getLine() {
        return rhs0 .getLine();
    }

    @Override
    public int getPos() {
        return rhs0 .getPos();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = (hash*(13 + rhs0 .hashCode()));
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
        if (!(o instanceof GroupRHS)) {
            return false;
        }
        GroupRHS castResult = ((GroupRHS) o);
        if (!this.rhs0 .equals(castResult.rhs0)) {
            return false;
        }
        return true;
    }

}
