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
package org.mitre.icarus.cps.exam.phase_1.response.trial_part_responses;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Subject/model response after an INT layer is shown in a Task 4 trial.
 * 
 * @author CBONACETO
 *
 */
@XmlType(name="Task_4_AttackLocationProbeResponseAfterINT", namespace="IcarusCPD_1",
		propOrder={"intLayerShown", "attackLocationResponse"})//, "surpriseReportResponse"})
public class Task_4_7_AttackLocationProbeResponseAfterINT extends TrialPartResponse {
	
	/** The INT layer that was shown or selected */
	protected INTLayerData intLayerShown;
	
	/** The probability response after the INT layer has been shown */
	protected AttackLocationProbeResponse_MultiLocation attackLocationResponse;
	
	/** The surprise report after the INT layer has been shown */
	//protected SurpriseReportProbeResponse surpriseReportResponse;	
	
	/**
	 * No arg constructor. 
	 */
	public Task_4_7_AttackLocationProbeResponseAfterINT() {}
	
	/**
	 * Constructor that takes the intLayerShown and the attackLocationResponse.
	 * 
	 * @param intLayerShown the INT layer that was shown
	 * @param attackLocationResponse the attack location response
	 */
	public Task_4_7_AttackLocationProbeResponseAfterINT(INTLayerData intLayerShown, 
			AttackLocationProbeResponse_MultiLocation attackLocationResponse) {
		this.intLayerShown = intLayerShown;
		this.attackLocationResponse = attackLocationResponse;
	}	

	/**
	 * Get the INT layer that was shown.
	 * 
	 * @return the INT layer
	 */
	@XmlElement(name="INTLayerShown")
	public INTLayerData getIntLayerShown() {
		return intLayerShown;
	}

	/**
	 * Set the INT layer that was shown.
	 * 
	 * @param intLayerShown the INT layer
	 */
	public void setIntLayerShown(INTLayerData intLayerShown) {
		this.intLayerShown = intLayerShown;
	}

	/**
	 * Get the response to the location probe where the subject/model indicates the probability that
	 * a group is responsible for an attack at each location.
	 * 
	 * @return the location probe response
	 */
	@XmlElement(name="LocationResponse")
	public AttackLocationProbeResponse_MultiLocation getAttackLocationResponse() {
		return attackLocationResponse;
	}

	/**
	 * Set the response to the location probe where the subject/model indicates the probability that
	 * a group is responsible for an attack at each location.
	 * 
	 * @param attackLocationResponse the location probe response
	 */
	public void setAttackLocationResponse(
			AttackLocationProbeResponse_MultiLocation attackLocationResponse) {
		this.attackLocationResponse = attackLocationResponse;
	}
	
	/**
	 * Get the response to the surprise probe after the INT layer is shown.
	 * 
	 * @return the surprise response
	 */
	/*@XmlElement(name="SurpriseReportResponse")
	public SurpriseReportProbeResponse getSurpriseReportResponse() {
		return surpriseReportResponse;
	}*/

	/**
	 * Set the response to the surprise probe after the INT layer is shown.
	 * 
	 * @param surpriseReportResponse the surprise response
	 */
	/*public void setSurpriseReportResponse(SurpriseReportProbeResponse surpriseReportResponse) {
		this.surpriseReportResponse = surpriseReportResponse;
	}*/
}