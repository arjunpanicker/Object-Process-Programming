/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.*;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.osgi.internal.loader.ModuleClassLoader.GenerationProtectionDomain;

import com.vainolo.phd.opp.model.OPPContainer;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.editor.OPPGraphicalEditor;
import com.vainolo.phd.opp.editor.factory.OPPIdManager;
import com.vainolo.phd.opp.editor.figure.OPPNodeFigure;
import com.vainolo.phd.opp.editor.policy.OPPLinkConnectionEditPolicy;
import com.vainolo.phd.opp.editor.policy.OPPNodeEditPolicy;
import com.vainolo.phd.opp.validation.OPPLinkValidator;

public abstract class OPPNodeEditPart extends AbstractGraphicalEditPart implements NodeEditPart {

  protected OPMNodeAdapter adapter;

  public OPPNodeEditPart() {
    super();
    adapter = new OPMNodeAdapter();
  }

  @Override
  protected List<OPPLink> getModelSourceConnections() {
    OPPNode model = (OPPNode) getModel();
    return model.getOutgoingLinks();
  }

  @Override
  protected List<OPPLink> getModelTargetConnections() {
    OPPNode model = (OPPNode) getModel();
    return model.getIncomingLinks();
  }

  @Override
  public void activate() {
    if (!isActive()) {
      ((OPPNode) getModel()).eAdapters().add(adapter);
    }
    super.activate();
  }

  @Override
  public void deactivate() {
    if (isActive()) {
      ((OPPNode) getModel()).eAdapters().remove(adapter);
    }

    super.deactivate();
  }

  /**
   * Install edit policies that can be applied to {@link OPPNodeEditPart} instances.
   */
  @Override
  protected void createEditPolicies() {
    OPPIdManager idManager = ((OPPGraphicalEditor) ((DefaultEditDomain) (getViewer().getEditDomain())).getEditorPart()).getIdManager();
    installEditPolicy(EditPolicy.COMPONENT_ROLE, new OPPNodeEditPolicy());
    installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new OPPLinkConnectionEditPolicy(new OPPLinkValidator(), idManager));
  }

  @Override
  protected List<OPPNode> getModelChildren() {
    OPPNode model = (OPPNode) getModel();
    if (model instanceof OPPContainer) {
      OPPContainer container = (OPPContainer) model;
      return Collections.unmodifiableList(container.getNodes());
    } else {
      return Collections.emptyList();
    }
  }

  protected ConnectionAnchor getSourceConnectionAnchor() {
    return new ChopboxAnchor(getFigure());
  }

  @Override
  public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
    return getSourceConnectionAnchor();
  }

  @Override
  public ConnectionAnchor getSourceConnectionAnchor(Request request) {
    return getSourceConnectionAnchor();
  }

  protected ConnectionAnchor getTargetConnectionAnchor() {
    return new ChopboxAnchor(getFigure());
  }

  @Override
  public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
    return getTargetConnectionAnchor();
  }

  @Override
  public ConnectionAnchor getTargetConnectionAnchor(Request request) {
    return getTargetConnectionAnchor();
  }

  public class OPMNodeAdapter implements Adapter {

    /**
     * For all changes in the model, refresh visuals, source and target.
     */
    @Override
    public void notifyChanged(Notification notification) {
      refresh();
    }

    @Override
    public Notifier getTarget() {
      return (OPPNode) getModel();
    }

    @Override
    public void setTarget(Notifier newTarget) {
      // Do nothing.
    }

    @Override
    public boolean isAdapterForType(Object type) {
      return type.equals(OPPNode.class);
    }
  }
}