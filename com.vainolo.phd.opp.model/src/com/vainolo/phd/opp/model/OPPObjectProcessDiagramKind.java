/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/**
 */
package com.vainolo.phd.opp.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Object Process Diagram Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.vainolo.phd.opp.model.OPPPackage#getOPPObjectProcessDiagramKind()
 * @model
 * @generated
 */
public enum OPPObjectProcessDiagramKind implements Enumerator {
  /**
   * The '<em><b>COMPOUND</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COMPOUND_VALUE
   * @generated
   * @ordered
   */
  COMPOUND(1, "COMPOUND", "Compound"),

  /**
   * The '<em><b>UNFOLDED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UNFOLDED_VALUE
   * @generated
   * @ordered
   */
  UNFOLDED(2, "UNFOLDED", "Unfolded"),

  /**
   * The '<em><b>SYSTEM</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SYSTEM_VALUE
   * @generated
   * @ordered
   */
  SYSTEM(3, "SYSTEM", "System"), /**
   * The '<em><b>IN ZOOMED PROCESS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_ZOOMED_PROCESS_VALUE
   * @generated
   * @ordered
   */
  IN_ZOOMED_PROCESS(4, "IN_ZOOMED_PROCESS", "In-Zoomed Process"), /**
   * The '<em><b>IN ZOOMED OBJECT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_ZOOMED_OBJECT_VALUE
   * @generated
   * @ordered
   */
  IN_ZOOMED_OBJECT(5, "IN_ZOOMED_OBJECT", "In-Zoomed Object"), /**
   * The '<em><b>UNFOLDED PROCESS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UNFOLDED_PROCESS_VALUE
   * @generated
   * @ordered
   */
  UNFOLDED_PROCESS(6, "UNFOLDED_PROCESS", "Unfolded Process"), /**
   * The '<em><b>UNFOLDED OBJECT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UNFOLDED_OBJECT_VALUE
   * @generated
   * @ordered
   */
  UNFOLDED_OBJECT(7, "UNFOLDED_OBJECT", "Unfolded Object"), /**
   * The '<em><b>FREE FORM</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FREE_FORM_VALUE
   * @generated
   * @ordered
   */
  FREE_FORM(8, "FREE_FORM", "Free Form");

  /**
   * The '<em><b>COMPOUND</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>COMPOUND</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #COMPOUND
   * @model literal="Compound"
   * @generated
   * @ordered
   */
  public static final int COMPOUND_VALUE = 1;

  /**
   * The '<em><b>UNFOLDED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>UNFOLDED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #UNFOLDED
   * @model literal="Unfolded"
   * @generated
   * @ordered
   */
  public static final int UNFOLDED_VALUE = 2;

  /**
   * The '<em><b>SYSTEM</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SYSTEM</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SYSTEM
   * @model literal="System"
   * @generated
   * @ordered
   */
  public static final int SYSTEM_VALUE = 3;

  /**
   * The '<em><b>IN ZOOMED PROCESS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IN ZOOMED PROCESS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IN_ZOOMED_PROCESS
   * @model literal="In-Zoomed Process"
   * @generated
   * @ordered
   */
  public static final int IN_ZOOMED_PROCESS_VALUE = 4;

  /**
   * The '<em><b>IN ZOOMED OBJECT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IN ZOOMED OBJECT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IN_ZOOMED_OBJECT
   * @model literal="In-Zoomed Object"
   * @generated
   * @ordered
   */
  public static final int IN_ZOOMED_OBJECT_VALUE = 5;

  /**
   * The '<em><b>UNFOLDED PROCESS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>UNFOLDED PROCESS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #UNFOLDED_PROCESS
   * @model literal="Unfolded Process"
   * @generated
   * @ordered
   */
  public static final int UNFOLDED_PROCESS_VALUE = 6;

  /**
   * The '<em><b>UNFOLDED OBJECT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>UNFOLDED OBJECT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #UNFOLDED_OBJECT
   * @model literal="Unfolded Object"
   * @generated
   * @ordered
   */
  public static final int UNFOLDED_OBJECT_VALUE = 7;

  /**
   * The '<em><b>FREE FORM</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FREE FORM</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FREE_FORM
   * @model literal="Free Form"
   * @generated
   * @ordered
   */
  public static final int FREE_FORM_VALUE = 8;

  /**
   * An array of all the '<em><b>Object Process Diagram Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final OPPObjectProcessDiagramKind[] VALUES_ARRAY =
    new OPPObjectProcessDiagramKind[] {
      COMPOUND,
      UNFOLDED,
      SYSTEM,
      IN_ZOOMED_PROCESS,
      IN_ZOOMED_OBJECT,
      UNFOLDED_PROCESS,
      UNFOLDED_OBJECT,
      FREE_FORM,
    };

  /**
   * A public read-only list of all the '<em><b>Object Process Diagram Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<OPPObjectProcessDiagramKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Object Process Diagram Kind</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static OPPObjectProcessDiagramKind get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      OPPObjectProcessDiagramKind result = VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Object Process Diagram Kind</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static OPPObjectProcessDiagramKind getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      OPPObjectProcessDiagramKind result = VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Object Process Diagram Kind</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static OPPObjectProcessDiagramKind get(int value) {
    switch (value) {
      case COMPOUND_VALUE: return COMPOUND;
      case UNFOLDED_VALUE: return UNFOLDED;
      case SYSTEM_VALUE: return SYSTEM;
      case IN_ZOOMED_PROCESS_VALUE: return IN_ZOOMED_PROCESS;
      case IN_ZOOMED_OBJECT_VALUE: return IN_ZOOMED_OBJECT;
      case UNFOLDED_PROCESS_VALUE: return UNFOLDED_PROCESS;
      case UNFOLDED_OBJECT_VALUE: return UNFOLDED_OBJECT;
      case FREE_FORM_VALUE: return FREE_FORM;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private OPPObjectProcessDiagramKind(int value, String name, String literal) {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue() {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral() {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    return literal;
  }
  
} //OPPObjectProcessDiagramKind
