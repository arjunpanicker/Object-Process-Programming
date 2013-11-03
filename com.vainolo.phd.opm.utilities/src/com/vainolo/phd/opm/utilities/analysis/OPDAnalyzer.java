package com.vainolo.phd.opm.utilities.analysis;

import java.util.Collection;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;

public class OPDAnalyzer {
  private OPDAnalysis analyzer = OPDAnalysis.INSTANCE;

  /**
   * Recursively find the OPD that contains the node.
   * 
   * @param node
   *          that is contained in the OPD (maybe down many levels).
   * @return the OPD where the node is contained.
   */
  public OPMObjectProcessDiagram findOPD(OPMNode node) {
    OPMContainer currentContainer = node.getContainer();
    while(!(currentContainer instanceof OPMObjectProcessDiagram)) {
      currentContainer = ((OPMNode) currentContainer).getContainer();
    }
    return (OPMObjectProcessDiagram) currentContainer;
  }

  /**
   * Find all the variables directly contained in an OPD.
   * 
   * @param opd
   *          to search.
   * @return all variables directly contained in the OPD.
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMObject> findVariables(OPMObjectProcessDiagram opd) {
    return (Collection) Collections2.filter(opd.getNodes(), IsOPMVariable.INSTANCE);
  }

  /**
   * Predicate to search for variables.
   * 
   * @author Arieh "Vainolo" Bibliowicz
   * 
   */
  public enum IsOPMVariable implements Predicate<OPMNode> {
    INSTANCE;

    @Override
    public boolean apply(final OPMNode node) {
      if(OPMObject.class.isInstance(node)) {
        OPMObject o = (OPMObject) node;
        if(!o.isParameter()) {
          return true;
        }
      }
      return false;
    }
  }
}
