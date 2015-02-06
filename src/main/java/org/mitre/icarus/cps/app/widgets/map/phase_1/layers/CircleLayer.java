/* 
 * NOTICE
 * This software was produced for the office of the Director of National Intelligence (ODNI)
 * Intelligence Advanced Research Projects Activity (IARPA) ICArUS program, 
 * BAA number IARPA-BAA-10-04, under contract 2009-0917826-016, and is subject 
 * to the Rights in Data-General Clause 52.227-14, Alt. IV (DEC 2007).
 * 
 * This software and data is provided strictly to support demonstrations of ICArUS challenge problems
 * and to assist in the development of cognitive-neuroscience architectures. It is not intended to be used
 * in operational systems or environments.
 * 
 * Copyright (C) 2015 The MITRE Corporation. All Rights Reserved.
 * 
 */
package org.mitre.icarus.cps.app.widgets.map.phase_1.layers;

import java.awt.geom.Point2D;
import java.util.Collection;

import org.mitre.icarus.cps.app.widgets.map.phase_1.IMapPanel_Phase1;
import org.mitre.icarus.cps.app.widgets.map.phase_1.editors.CircleEditor;
import org.mitre.icarus.cps.app.widgets.map.phase_1.editors.IMapObjectEditor;
import org.mitre.icarus.cps.app.widgets.map.phase_1.objects.CircleShape;

/**
 * A layer that only contains circle map objects. Overrides functionality
 * in AbstractEditableLayer to determine the circle closest to the mouse
 * based on distance to circle centers and edges.
 * 
 * @author CBONACETO
 *
 */
public class CircleLayer extends AbstractEditableLayer<CircleShape> {
	
	public CircleLayer(String id, IMapPanel_Phase1 map) {
		super(id, map);
		setSelectable(true);
	}
	
	/* Override default behavior to get the object whose bounds contain the location and whose center point or edge is closest to the location.
	 * If center point or edge is equi-distant for multiple objects whose bounds contain the location, the smallest object is returned.
	 * 
	 * (non-Javadoc)	  
	 * @see org.mitre.icarus.cps.gui.phase_1.feature_vector.layers.BasicLayer#getFirstObjectAtLocation(java.awt.geom.Point2D)
	 */
	@Override
	public CircleShape getFirstObjectAtLocation(Point2D location) {		
		//First get all circles at the location
		Collection<CircleShape> circles = super.getObjectsAtLocation(location);
		
		if(circles == null || circles.isEmpty()) {
			return null;
		} else if(circles.size() == 1) {
			//Return the first and only circle
			return circles.iterator().next();
		} else {			
			//Return the object with the closest center point or edge (break ties by returning the smallest object)
			CircleShape closest = null;
			double minDistanceToCenter = Double.MAX_VALUE;
			double minDistanceToEdge = Double.MAX_VALUE;
			for(CircleShape circle : circles) {
				double distanceToCenter = computeDistanceToCenter(circle, location);
				if(closest == null) {
					closest = circle;
					minDistanceToCenter = distanceToCenter;
					if(distanceToCenter > 0) {
						minDistanceToEdge = computeDistanceToEdge(circle, distanceToCenter);
						//System.out.println("Distance to circle " + circle.getId() + ": " + distanceToCenter + ", " + minDistanceToEdge);
					}
					//else {
					//	System.out.println("Distance to circle " + circle.getId() + ": " + distanceToCenter);
					//}
				}
				else {
					if(distanceToCenter == 0) {
						if(minDistanceToCenter > 0 || circle.getRadius() < closest.getRadius()) {
							closest = circle;
							minDistanceToCenter = 0;
						}
						//System.out.println("Distance to circle " + circle.getId() + ": " + distanceToCenter);
					}
					else {
						double distanceToEdge = computeDistanceToEdge(circle, distanceToCenter);
						double min1 = Math.min(distanceToCenter, distanceToEdge);
						double min2 = Math.min(minDistanceToCenter, minDistanceToEdge); 
						if(min1 < min2 || (min1 == min2 && circle.getRadius() < closest.getRadius())) {							
							closest = circle;
							minDistanceToCenter = distanceToCenter;
							minDistanceToEdge = distanceToEdge;
						}
						//System.out.println("Distance to circle " + circle.getId() + ": " + distanceToCenter + ", " + distanceToEdge);
					}
				}
			}			
			//System.out.println(closest.getId() +  " is closest"); System.out.println();
			return closest;
		}
	}
	
	private double computeDistance(Point2D p1, Point2D p2) {
		return Math.pow(p1.getX() - p2.getX(), 2) +
				Math.pow(p1.getY() - p2.getY(), 2);
	}
	
	private double computeDistanceToCenter(CircleShape circle, Point2D location) {
		if(circle.centerControlPointContains(location.getX(), location.getY())) {
			return 0;
		}
		return computeDistance(circle.getCenterLocation_pixels(), location);
	}
	
	private double computeDistanceToEdge(CircleShape circle, double distanceToCenter) {
		return Math.abs(distanceToCenter - Math.pow(circle.getRadius_pixels(), 2));
	}

	@Override
	public IMapObjectEditor<CircleShape> editObject(CircleShape circleShape) {						
		if(!editingObjects.containsKey(circleShape)) {
			// create the editor
			CircleEditor circleEditor = new CircleEditor();

			editingObjects.put(circleShape, new ObjectAndEditor<CircleShape>(circleShape, circleEditor));
			circleEditor.editMapObject(circleShape, this, map);

			return circleEditor;
		}
		return null;
	}	
}