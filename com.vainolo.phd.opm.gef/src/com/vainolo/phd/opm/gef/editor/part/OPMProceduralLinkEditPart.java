/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.geometry.PointList;

import com.vainolo.phd.opm.gef.editor.figure.CircleDecoration;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;

/**
 * An extension of a {@link OPMLinkEditPart} used for {@link OPMProceduralLink} instances. It add endpoint decorations
 * to the regular link figure.
 * 
 * @author vainolo
 * 
 */
public class OPMProceduralLinkEditPart extends OPMLinkEditPart {

	private Label targetDecorationLabel;
	private Label sourceDecorationLabel;
	private Label centerDecorationLabel;

	/**
	 * Extend the connection created by {@link OPMLinkEditPart#createFigure()} by adding decorations depending on the
	 * link kind. An agent link is decorated at the target with black filled {@link CircleDecoration}. An instrument
	 * link is decorated at the target with a white filled {@link CircleDecoration}. A consumption or result link is
	 * decorated at the target with a {@link PolylineDecoration} (which is an arrow). An effect link link is decorated
	 * at the source and target with a {@link PolylineDecoration}.
	 * 
	 * @return a decorated {@link PolylineConnection} figure.
	 */
	@Override
	protected PolylineConnection createFigure() {
		PolylineConnection connection = super.createFigure();
		OPMProceduralLink model = (OPMProceduralLink) getModel();
		decorateConnection(connection, model.getKind());
		sourceDecorationLabel = new Label();
		centerDecorationLabel = new Label();
		targetDecorationLabel = new Label();
		ConnectionLocator locator = new ConnectionLocator(connection, ConnectionLocator.SOURCE);
		connection.add(sourceDecorationLabel, locator);
		locator = new ConnectionLocator(connection, ConnectionLocator.MIDDLE);
		connection.add(centerDecorationLabel, locator);
		locator = new ConnectionLocator(connection, ConnectionLocator.TARGET);
		connection.add(targetDecorationLabel, locator);
		return connection;
	}

	@Override
	protected void refreshVisuals() {
		OPMProceduralLink model = (OPMProceduralLink) getModel();
		targetDecorationLabel.setText(model.getTargetDecoration());
		centerDecorationLabel.setText(model.getCenterDecoration());
		sourceDecorationLabel.setText(model.getSourceDecoration());
		super.refreshVisuals();
	}

	/**
	 * Decorate a connection depending on its kind.
	 * 
	 * @param connection
	 *            the {@link PolylineConnection} to decorate.
	 * @param kind
	 *            the {@link OPMProceduralLinkKind} of the model entity.
	 */
	private void decorateConnection(PolylineConnection connection, OPMProceduralLinkKind kind) {
		switch (kind) {
		case AGENT:
			CircleDecoration agentDecoration = new CircleDecoration();
			agentDecoration.setBackgroundColor(ColorConstants.black);
			agentDecoration.setFill(true);
			connection.setTargetDecoration(agentDecoration);
			break;
		case INSTRUMENT:
			CircleDecoration instrumentDecoration = new CircleDecoration();
			instrumentDecoration.setBackgroundColor(ColorConstants.white);
			instrumentDecoration.setFill(true);
			connection.setTargetDecoration(instrumentDecoration);
			break;
		case CONSUMPTION:
		case RESULT:
		case INVOCATION:
			connection.setTargetDecoration(new PolylineDecoration());
			break;
		case EFFECT:
			connection.setSourceDecoration(new PolylineDecoration());
			connection.setTargetDecoration(new PolylineDecoration());
			break;
		case CONDITION:
			PolylineDecoration decoration = new PolylineDecoration();
			decoration.add(new Label("c"));
			connection.setTargetDecoration(decoration);
			break;
		case EVENT:
			decoration = new PolylineDecoration();
			PointList pl = new PointList();
			pl.addPoint(0, 1);
			pl.addPoint(-1, 1);
			pl.addPoint(-1, 0);
			pl.addPoint(0, 0);
			pl.addPoint(-1, 0);
			pl.addPoint(-1, -1);
			pl.addPoint(0, -1);
			decoration.setTemplate(pl);
			decoration.setScale(5, 5);
			connection.setTargetDecoration(decoration);
			break;
		default:
			throw new IllegalArgumentException("No case for kind " + kind);
		}
	}
}
