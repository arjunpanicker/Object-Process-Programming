/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter;

public class OPPParameter {
  String name;
  boolean isCollection;

  public OPPParameter(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}