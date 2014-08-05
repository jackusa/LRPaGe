
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
        //do nothing
    }

    @Override
    public RHSAbstractNode replace() {
        return rhs0;
    }

}