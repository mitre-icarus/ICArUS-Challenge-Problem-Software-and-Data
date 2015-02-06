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
package org.mitre.icarus.cps.exam.phase_1.testing;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;

import org.mitre.icarus.cps.exam.phase_1.response.Task_3_ProbeTrialResponse;
import org.mitre.icarus.cps.exam.phase_1.testing.trial_part_probes.AttackLocationProbe_MultiGroup;
import org.mitre.icarus.cps.exam.phase_1.testing.trial_part_probes.GroupCentersProbe;
import org.mitre.icarus.cps.exam.phase_1.testing.trial_part_probes.SurpriseReportProbe;
import org.mitre.icarus.cps.exam.phase_1.testing.trial_part_probes.TroopSelectionProbe_MultiGroup;

/**
 * Probe trial after a block of group attack presentations in Task 3.
 * 
 * @author CBONACETO
 *
 */
@XmlType(name="Task_3_ProbeTrial", namespace="IcarusCPD_1", 
		propOrder={"attackDispersionParameters", "centersToAttackDistances", "groupCentersProbe", "attackLocationProbe", "troopSelectionProbe", 
		"groundTruth", "groundTruthSurpriseProbe", "trialResponse"})
public class Task_3_ProbeTrial extends Task_1_2_3_ProbeTrialBase {
	
	/** The group centers of gravity probe */
	protected GroupCentersProbe groupCentersProbe;
	
	/** Subject/model response to the probe trial */
	protected Task_3_ProbeTrialResponse trialResponse;
	
	/** The computed shortest path "cow-walk" distances from the attack location probed to the normative group centers */
	protected ArrayList<Double> centersToAttackDistances;
	
	/* (non-Javadoc)
	 * @see org.mitre.icarus.cps.exam.phase_1.testing.Task_1_2_3_ProbeTrialBase#getAttackLocationProbe()
	 */
	@XmlElement(name="GroupProbe")
	@Override
	public AttackLocationProbe_MultiGroup getAttackLocationProbe() {		
		return super.getAttackLocationProbe();
	}
	
	/* (non-Javadoc)
	 * @see org.mitre.icarus.cps.exam.phase_1.testing.Task_1_2_3_ProbeTrialBase#setAttackLocationProbe(org.mitre.icarus.cps.exam.phase_1.testing.trial_part_probes.AttackLocationProbe_MultiGroup)
	 */
	@Override
	public void setAttackLocationProbe(	AttackLocationProbe_MultiGroup attackLocationProbe) {
		super.setAttackLocationProbe(attackLocationProbe);
	}
	
	/* (non-Javadoc)
	 * @see org.mitre.icarus.cps.exam.phase_1.testing.Task_1_2_3_ProbeTrialBase#getTroopSelectionProbe()
	 */
	@XmlElement(name="TroopSelectionProbe")
	@Override
	public TroopSelectionProbe_MultiGroup getTroopSelectionProbe() {
		return super.getTroopSelectionProbe();
	}
	
	/* (non-Javadoc)
	 * @see org.mitre.icarus.cps.exam.phase_1.testing.Task_1_2_3_ProbeTrialBase#setTroopSelectionProbe(org.mitre.icarus.cps.exam.phase_1.testing.trial_part_probes.TroopSelectionProbe_MultiGroup)
	 */
	@Override
	public void setTroopSelectionProbe(TroopSelectionProbe_MultiGroup troopSelectionProbe) {
		super.setTroopSelectionProbe(troopSelectionProbe);
	}
	
	/**
	 * Get the group centers probe.
	 * 
	 * @return the group centers probe
	 */
	@XmlElement(name="GroupCentersProbe")
	public GroupCentersProbe getGroupCentersProbe() {
		return groupCentersProbe;
	}

	/**
	 * Set the group centers probe.
	 * 
	 * @param groupCentersProbe the group centers probe
	 */
	public void setGroupCentersProbe(GroupCentersProbe groupCentersProbe) {
		this.groupCentersProbe = groupCentersProbe;
	}
	
	/* (non-Javadoc)
	 * @see org.mitre.icarus.cps.exam.phase_1.testing.Task_1_2_3_ProbeTrialBase#getGroundTruth()
	 */
	@XmlElement(name="GroundTruth")
	@Override
	public GroundTruth getGroundTruth() {
		return super.getGroundTruth();
	}
	
	/* (non-Javadoc)
	 * @see org.mitre.icarus.cps.exam.phase_1.testing.Task_1_2_3_ProbeTrialBase#setGroundTruth(org.mitre.icarus.cps.exam.phase_1.testing.GroundTruth)
	 */
	@Override
	public void setGroundTruth(GroundTruth groundTruth) {		
		super.setGroundTruth(groundTruth);
	}
	
	/* (non-Javadoc)
	 * @see org.mitre.icarus.cps.exam.phase_1.testing.Task_1_2_3_ProbeTrialBase#getGroundTruthSurpriseProbe()
	 */
	@XmlElement(name="GroundTruthSurpriseProbe")
	@Override
	public SurpriseReportProbe getGroundTruthSurpriseProbe() {	
		return super.getGroundTruthSurpriseProbe();
	}
	
	/* (non-Javadoc)
	 * @see org.mitre.icarus.cps.exam.phase_1.testing.Task_1_2_3_ProbeTrialBase#setGroundTruthSurpriseProbe(org.mitre.icarus.cps.exam.phase_1.testing.trial_part_probes.SurpriseReportProbe)
	 */
	@Override
	public void setGroundTruthSurpriseProbe(SurpriseReportProbe groundTruthSurpriseProbe) {
		super.setGroundTruthSurpriseProbe(groundTruthSurpriseProbe);
	}
	
	/* (non-Javadoc)
	 * @see org.mitre.icarus.cps.exam.phase_1.testing.Task_1_2_3_ProbeTrialBase#getAttackDispersionParameters()
	 */
	@XmlElementWrapper(name="AttackDispersionParameters")
	@XmlElement(name="Parameters")
	@Override
	public ArrayList<Task_1_2_3_AttackDispersionParameters> getAttackDispersionParameters() {
		return super.getAttackDispersionParameters();
	}

	/* (non-Javadoc)
	 * @see org.mitre.icarus.cps.exam.phase_1.testing.Task_1_2_3_ProbeTrialBase#setAttackDispersionParameters(org.mitre.icarus.cps.exam.phase_1.testing.Task_1_2_3_AttackDispersionParameters)
	 */
	@Override
	public void setAttackDispersionParameters(
			ArrayList<Task_1_2_3_AttackDispersionParameters> attackDispersionParameters) {
		super.setAttackDispersionParameters(attackDispersionParameters);
	}
	
	/**
	 * Get the computed shortest path "cow-walk" distances from the attack location to each normative group center specified in the attackDispersionParameters.
	 * 
	 * @return the distances in miles
	 */	
	@XmlElement(name="CentersToAttackDistances")
	@XmlList
	public ArrayList<Double> getCentersToAttackDistances() {
		return centersToAttackDistances;
	}

	/**
	 * Set the computed shortest path "cow-walk" distances from the attack location to each normative group center specified in the attackDispersionParameters.
	 * 
	 * @param centersToAttackDistances the distances in miles
	 */
	public void setCentersToAttackDistances(ArrayList<Double> centersToAttackDistances) {
		this.centersToAttackDistances = centersToAttackDistances;
	}

	/* (non-Javadoc)
	 * @see org.mitre.icarus.cps.exam.phase_1.testing.Task_1_2_3_ProbeTrialBase#getTrialResponse()
	 */
	@XmlElement(name="TrialResponse")
	@Override
	public Task_3_ProbeTrialResponse getTrialResponse() {
		return trialResponse;
	}

	/**
	 * Set the trial response.
	 * 
	 * @param trialResponse the trial response
	 */
	public void setTrialResponse(Task_3_ProbeTrialResponse trialResponse) {
		this.trialResponse = trialResponse;
	}

	/* (non-Javadoc)
	 * @see org.mitre.icarus.cps.exam.base.testing.IcarusTestTrial#getTestTrialType()
	 */
	@SuppressWarnings("deprecation")
	@Override
	public TestTrialType getTestTrialType() {
		return TestTrialType.Task_3_Probe_Trial;
	}
}