/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor;

import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteStack;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.SelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.tools.MarqueeSelectionTool;
import org.eclipse.jface.resource.ImageDescriptor;

import com.vainolo.phd.opm.gef.editor.factory.LabelFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMAgentLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMAggregationStructuralLinkAggregatorFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMConsumptionConditionLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMConsumptionEventLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMConsumptionLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMEffectLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMExhibitionStructuralLinkAggregatorFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMGeneralizationStructuralLinkAggregatorFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMInstrumentConditionLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMInstrumentEventLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMInstrumentLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMInvocationLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMObjectFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMProcessFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMResultLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMStateFactory;
import com.vainolo.phd.opm.gef.editor.tool.CreationAndDirectEditTool;

/**
 * Tool pallete for the {@link OPMGraphicalEditor}.
 */
public class OPMGraphicalEditorPalette extends PaletteRoot {

  PaletteGroup group;

  public OPMGraphicalEditorPalette() {
    add(createGeneralPaletteTools());
    add(createBasicOPMPaletteTools());

    // addGroup();
    // addSelectionTool();
    // addNodeTools();
    // addOPMProceduralLinkTools();
    // addOPMStructuralLinkTools();
  }

  private PaletteDrawer createGeneralPaletteTools() {
    PaletteDrawer drawer = new PaletteDrawer("General");
    ToolEntry tool = new PanningSelectionToolEntry();
    drawer.add(tool);
    setDefaultEntry(tool);

    PaletteStack marqueeStack = new PaletteStack("Marquee Tools", "", null);

    // NODES CONTAINED (default)
    marqueeStack.add(new MarqueeToolEntry());

    // NODES TOUCHED
    MarqueeToolEntry marquee = new MarqueeToolEntry();
    marquee.setToolProperty(MarqueeSelectionTool.PROPERTY_MARQUEE_BEHAVIOR, new Integer(
        MarqueeSelectionTool.BEHAVIOR_NODES_TOUCHED));
    marqueeStack.add(marquee);

    // NODES CONTAINED AND RELATED CONNECTIONS
    marquee = new MarqueeToolEntry();
    marquee.setToolProperty(MarqueeSelectionTool.PROPERTY_MARQUEE_BEHAVIOR, new Integer(
        MarqueeSelectionTool.BEHAVIOR_NODES_CONTAINED_AND_RELATED_CONNECTIONS));
    marqueeStack.add(marquee);

    // NODES TOUCHED AND RELATED CONNECTIONS
    marquee = new MarqueeToolEntry();
    marquee.setToolProperty(MarqueeSelectionTool.PROPERTY_MARQUEE_BEHAVIOR, new Integer(
        MarqueeSelectionTool.BEHAVIOR_NODES_TOUCHED_AND_RELATED_CONNECTIONS));
    marqueeStack.add(marquee);

    // CONNECTIONS CONTAINED
    marquee = new MarqueeToolEntry();
    marquee.setToolProperty(MarqueeSelectionTool.PROPERTY_MARQUEE_BEHAVIOR, new Integer(
        MarqueeSelectionTool.BEHAVIOR_CONNECTIONS_CONTAINED));
    marqueeStack.add(marquee);

    // CONNECTIONS TOUCHED
    marquee = new MarqueeToolEntry();
    marquee.setToolProperty(MarqueeSelectionTool.PROPERTY_MARQUEE_BEHAVIOR, new Integer(
        MarqueeSelectionTool.BEHAVIOR_CONNECTIONS_TOUCHED));
    marqueeStack.add(marquee);

    marqueeStack.setUserModificationPermission(PaletteEntry.PERMISSION_NO_MODIFICATION);
    drawer.add(marqueeStack);

    return drawer;
  }

  private PaletteEntry createBasicOPMPaletteTools() {
    PaletteDrawer drawer = new PaletteDrawer("OPP Basic");
    drawer.add(new CreationToolEntry("Label", "Create new Label", new LabelFactory(), ImageDescriptor.createFromFile(
        this.getClass(), "icons/label.ico"), ImageDescriptor.createFromFile(this.getClass(), "icons/label.ico")));

    ToolEntry entry =
        new CombinedTemplateCreationEntry("OPMObject", "Create a new Object", new OPMObjectFactory(),
            ImageDescriptor.createFromFile(this.getClass(), "icons/object.ico"), ImageDescriptor.createFromFile(
                this.getClass(), "icons/object.ico"));
    entry.setToolClass(CreationAndDirectEditTool.class);
    drawer.add(entry);

    entry =
        new CreationToolEntry("OPMProcess", "Create a new Process", new OPMProcessFactory(),
            ImageDescriptor.createFromFile(this.getClass(), "icons/process.ico"), ImageDescriptor.createFromFile(
                this.getClass(), "icons/process.ico"));
    entry.setToolClass(CreationAndDirectEditTool.class);
    drawer.add(entry);

    entry =
        new CreationToolEntry("OPMState", "Create a new State", new OPMStateFactory(), ImageDescriptor.createFromFile(
            this.getClass(), "icons/state.ico"), ImageDescriptor.createFromFile(this.getClass(), "icons/state.ico"));
    entry.setToolClass(CreationAndDirectEditTool.class);
    drawer.add(entry);

    drawer.add(new ConnectionCreationToolEntry("Instrument", "Create a new Instrument link",
        new OPMInstrumentLinkFactory(), ImageDescriptor.createFromFile(this.getClass(), "icons/instrument.ico"),
        ImageDescriptor.createFromFile(this.getClass(), "icons/instrument.ico")));

    drawer.add(new ConnectionCreationToolEntry("Result", "Create a new Result link", new OPMResultLinkFactory(),
        ImageDescriptor.createFromFile(this.getClass(), "icons/result.ico"), ImageDescriptor.createFromFile(
            this.getClass(), "icons/result.ico")));

    return drawer;
  }

  private void addSelectionTool() {
    SelectionToolEntry entry = new SelectionToolEntry();
    group.add(entry);
    setDefaultEntry(entry);
  }

  private void addGroup() {
    group = new PaletteGroup("OPM Controls");
    add(group);
  }

  /**
   * Add tools to create procedural links in the diagram.
   */
  private void addOPMProceduralLinkTools() {
    ConnectionCreationToolEntry entry;

    entry =
        new ConnectionCreationToolEntry("Agent", "Create a new Agent link", new OPMAgentLinkFactory(),
            ImageDescriptor.createFromFile(this.getClass(), "icons/agent.ico"), ImageDescriptor.createFromFile(
                this.getClass(), "icons/agent.ico"));
    group.add(entry);

    entry =
        new ConnectionCreationToolEntry("Instrument", "Create a new Instrument link", new OPMInstrumentLinkFactory(),
            ImageDescriptor.createFromFile(this.getClass(), "icons/instrument.ico"), ImageDescriptor.createFromFile(
                this.getClass(), "icons/instrument.ico"));
    group.add(entry);

    entry =
        new ConnectionCreationToolEntry("Instrument Condition", "Create a new Instrument Condition link",
            new OPMInstrumentConditionLinkFactory(), ImageDescriptor.createFromFile(
                this.getClass(), "icons/instrument_condition.ico"), ImageDescriptor.createFromFile(
                this.getClass(), "icons/instrument_condition.ico"));
    group.add(entry);

    entry =
        new ConnectionCreationToolEntry("Instrument Event", "Create a new Instrument Event link",
            new OPMInstrumentEventLinkFactory(), ImageDescriptor.createFromFile(
                this.getClass(), "icons/instrument_event.ico"), ImageDescriptor.createFromFile(
                this.getClass(), "icons/instrument_event.ico"));
    group.add(entry);

    entry =
        new ConnectionCreationToolEntry("Consumption", "Create a new Consumption link",
            new OPMConsumptionLinkFactory(), ImageDescriptor.createFromFile(this.getClass(), "icons/consumption.ico"),
            ImageDescriptor.createFromFile(this.getClass(), "icons/consumption.ico"));
    group.add(entry);

    entry =
        new ConnectionCreationToolEntry("Consumption Condition", "Create a new Consumption Condition link",
            new OPMConsumptionConditionLinkFactory(), ImageDescriptor.createFromFile(
                this.getClass(), "icons/consumption_condition.ico"), ImageDescriptor.createFromFile(
                this.getClass(), "icons/consumption_condition.ico"));
    group.add(entry);

    entry =
        new ConnectionCreationToolEntry("Consumption Event", "Create a new Consumption Event link",
            new OPMConsumptionEventLinkFactory(), ImageDescriptor.createFromFile(
                this.getClass(), "icons/consumption_event.ico"), ImageDescriptor.createFromFile(
                this.getClass(), "icons/consumption_event.ico"));
    group.add(entry);

    entry =
        new ConnectionCreationToolEntry("Effect", "Create a new Effect link", new OPMEffectLinkFactory(),
            ImageDescriptor.createFromFile(this.getClass(), "icons/effect.ico"), ImageDescriptor.createFromFile(
                this.getClass(), "icons/effect.ico"));
    group.add(entry);

    entry =
        new ConnectionCreationToolEntry("Invocation", "Create a new Invocation link", new OPMInvocationLinkFactory(),
            ImageDescriptor.createFromFile(this.getClass(), "icons/invocation.ico"), ImageDescriptor.createFromFile(
                this.getClass(), "icons/invocation.ico"));
    group.add(entry);

    entry =
        new ConnectionCreationToolEntry("Result", "Create a new Result link", new OPMResultLinkFactory(),
            ImageDescriptor.createFromFile(this.getClass(), "icons/result.ico"), ImageDescriptor.createFromFile(
                this.getClass(), "icons/result.ico"));
    group.add(entry);
  }

  /**
   * Add tools to create structural links in the diagram.
   */
  private void addOPMStructuralLinkTools() {
    ConnectionCreationToolEntry entry;
    entry =
        new ConnectionCreationToolEntry("Aggregation", "Create a new Aggregation link",
            new OPMAggregationStructuralLinkAggregatorFactory(), ImageDescriptor.createFromFile(
                this.getClass(), "icons/aggregation.ico"), ImageDescriptor.createFromFile(
                this.getClass(), "icons/aggregation.ico"));
    group.add(entry);

    entry =
        new ConnectionCreationToolEntry("Exhibition", "Create a new Exhibition link",
            new OPMExhibitionStructuralLinkAggregatorFactory(), ImageDescriptor.createFromFile(
                this.getClass(), "icons/exhibition.ico"), ImageDescriptor.createFromFile(
                this.getClass(), "icons/exhibition.ico"));
    group.add(entry);

    entry =
        new ConnectionCreationToolEntry("Generalization", "Create a new Generalization link",
            new OPMGeneralizationStructuralLinkAggregatorFactory(), ImageDescriptor.createFromFile(
                this.getClass(), "icons/generalization.ico"), ImageDescriptor.createFromFile(
                this.getClass(), "icons/generalization.ico"));
    group.add(entry);
  }

}
