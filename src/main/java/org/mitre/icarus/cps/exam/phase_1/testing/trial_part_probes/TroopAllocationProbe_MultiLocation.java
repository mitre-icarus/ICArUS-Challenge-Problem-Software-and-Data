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
package org.mitre.icarus.cps.exam.phase_1.testing.trial_part_probes;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;


/**
 * A troop allocation probe where the subject/model allocates troops at
 * one or more locations.
 * 
 * @author CBONACETO
 *
 */
@XmlType(name="TroopAllocationProbe_MultiLocation", namespace="IcarusCPD_1")
public class TroopAllocationProbe_MultiLocation extends MultiLocationProbe {
	
	/**
	 * No arg constructor.
	 */
	public TroopAllocationProbe_MultiLocation() {}	
	
	/**
	 * Constructor that takes the locations to probe.
	 * 
	 * @param locations the locations
	 */
	public TroopAllocationProbe_MultiLocation(ArrayList<String> locations) {
		super(locations);
	}

	/* (non-Javadoc)
	 * @see org.mitre.icarus.cps.exam.phase_1.testing.trial_part_probes.MultiLocationProbe#getLocations()
	 */
	@XmlElement(name="Locations")
	@XmlList
	@Override
	public ArrayList<String> getLocations() {
		return super.getLocations();
	}

	/* (non-Javadoc)
	 * @see org.mitre.icarus.cps.exam.phase_1.testing.trial_part_probes.MultiLocationProbe#setLocations(java.util.ArrayList)
	 */
	@Override
	public void setLocations(ArrayList<String> locations) {
		super.setLocations(locations);
	}
}