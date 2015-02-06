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
package org.mitre.icarus.cps.app.experiment.ui_study.exam;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Base class for Tasks 2, 3, and 5, which all contain spatial
 * presentation trials.
 * 
 * @author CBONACETO
 *
 */
@XmlSeeAlso({Task_2_Phase.class, Task_3_Phase.class, Task_5_Phase.class})
public abstract class Task_2_3_5_PhaseBase extends Task_1_2_3_5_PhaseBase<SpatialPresentationTrial> {
	
	/** The spatial presentation trials */
	protected ArrayList<SpatialPresentationTrial> testTrials;
	
	@Override
	public DistributionType getDistributionType() {
		return DistributionType.Spatial;
	}
	
	@Override
	public ArrayList<SpatialPresentationTrial> getTestTrials() {
		return testTrials;
	}	

	public void setTestTrials(ArrayList<SpatialPresentationTrial> testTrials) {
		this.testTrials = testTrials;
	}
}