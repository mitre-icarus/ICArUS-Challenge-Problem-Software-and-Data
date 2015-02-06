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
package org.mitre.icarus.cps.app.experiment.phase_2;

import java.util.ArrayList;

import org.mitre.icarus.cps.app.experiment.phase_2.trial_states.Mission_4_5_6_TrialState;
import org.mitre.icarus.cps.exam.phase_2.testing.Mission_4_5_6;
import org.mitre.icarus.cps.exam.phase_2.testing.Mission_4_5_6_Trial;

/**
 * Controller for Missions 4-6. Nearly all controller functionality is now in the base MissionController since
 * Missions 1-6 are variations on the same task.
 * 
 * @author CBONACETO
 *
 */
public class Mission_4_5_6_Controller extends MissionController<Mission_4_5_6, Mission_4_5_6_TrialState> {	
	@Override
	protected void initializeMission(boolean clearResponseData) {	
		trialStates = new ArrayList<Mission_4_5_6_TrialState>();
		if(mission != null && mission.getTestTrials() != null && !mission.getTestTrials().isEmpty()) {
			int trialNum = 0;
			for(Mission_4_5_6_Trial trial : mission.getTestTrials()) {
				if(clearResponseData) {
					trial.clearResponseData();
				}
				trialStates.add(new Mission_4_5_6_TrialState(trialNum, trial, exam.getNormalizationMode(),
						ExperimentConstants_Phase2.RED_TACTIC_PROBABILITY_NORMALIZATION_MODE, 
						ExperimentConstants_Phase2.SHOW_BEGIN_TRIAL_PART_STATE));				
				trialNum++;
			}			
		}
	}
}