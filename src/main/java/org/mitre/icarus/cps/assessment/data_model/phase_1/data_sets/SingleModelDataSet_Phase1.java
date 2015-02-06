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
package org.mitre.icarus.cps.assessment.data_model.phase_1.data_sets;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.mitre.icarus.cps.assessment.data_model.base.data_sets.SingleModelDataSet;
import org.mitre.icarus.cps.assessment.data_model.phase_1.assessment_metrics.ExamMetrics;
import org.mitre.icarus.cps.assessment.data_model.phase_1.assessment_metrics.SubjectMetrics;
import org.mitre.icarus.cps.assessment.data_model.phase_1.assessment_metrics.TaskMetrics;
import org.mitre.icarus.cps.assessment.data_model.phase_1.assessment_metrics.TrialData;

/**
 * Data set containing results for a model run on a Phase 1 exam.
 *
 * @author CBONACETO
 *
 */
@Entity
@XmlRootElement
public class SingleModelDataSet_Phase1 extends SingleModelDataSet<TrialData, TaskMetrics, ExamMetrics, SubjectMetrics> {

    @Override
    @ManyToOne(cascade = CascadeType.ALL)
    @XmlElement
    public ExamMetrics getExamMetrics() {
        return examMetrics;
    }

    @Override
    public void setExamMetrics(ExamMetrics examMetrics) {
        this.examMetrics = examMetrics;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @Override
    @XmlElement
    public SubjectMetrics getSubjectMetrics() {
        return subjectMetrics;
    }

    @Override
    public void setSubjectMetrics(SubjectMetrics subjectMetrics) {
        this.subjectMetrics = subjectMetrics;
    }
}
