/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProceduralLinkKind;

/**
 * Factory used by palette tools to create {@link OPMProceduralLink} of
 * {@link OPMProceduralLinkKind#AGENT} kind.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPPAgentLinkFactory implements CreationFactory {

  private OPPIdManager idManager;

  public OPPAgentLinkFactory(OPPIdManager idManager) {
    this.idManager = idManager;
  }

  @Override
  public Object getNewObject() {
    OPPProceduralLink link = OPPFactory.eINSTANCE.createOPPProceduralLink();
    link.setKind(OPPProceduralLinkKind.AGENT);
    link.setId(idManager.getNextId());
    return link;
  }

  @Override
  public Object getObjectType() {
    return OPPProceduralLink.class;
  }

}
