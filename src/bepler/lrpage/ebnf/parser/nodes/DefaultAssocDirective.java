
package bepler.lrpage.ebnf.parser.nodes;

import bepler.lrpage.ebnf.parser.Visitor;


/**
 * This class was generated by the LRPaGe parser generator v1.0 using the com.sun.codemodel library.
 * 
 * <P>LRPaGe is available from https://github.com/tbepler/LRPaGe.
 * <P>CodeModel is available from https://codemodel.java.net/.
 * 
 */
public class DefaultAssocDirective
    extends DirectiveAbstractNode
{

    public final AssocAbstractNode assoc0;

    public DefaultAssocDirective(DefaultKeywordToken defaultkeyword0, AssocAbstractNode assoc1, TerminationToken termination2) {
        this.assoc0 = assoc1;
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
        if (!(o instanceof DefaultAssocDirective)) {
            return false;
        }
        DefaultAssocDirective castResult = ((DefaultAssocDirective) o);
        if (!this.assoc0 .equals(castResult.assoc0)) {
            return false;
        }
        return true;
    }

}
