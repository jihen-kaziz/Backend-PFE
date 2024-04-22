package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CV;
import com.example.demo.model.Education;
import com.example.demo.model.Experience;
import com.example.demo.model.JobApplication;
import com.example.demo.model.Skill;
import com.example.demo.repository.ICVRepository;
import com.example.demo.repository.IEducationRepository;
import com.example.demo.repository.IExperienceRepository;
import com.example.demo.repository.IJobApplicationRepository;
import com.example.demo.repository.ISkillRepository;

@Service
public class CVService
{
	@Autowired
	ICVRepository cvRep;
	
	@Autowired
	IJobApplicationRepository jobapplicationRep;
	
	@Autowired
	IEducationRepository educationRep;
	
	@Autowired
	IExperienceRepository experienceRep;
	
	@Autowired
	ISkillRepository skillRep;
	
	public CV addCV(CV cv, long idjobapplication) 
	{
		JobApplication jobapplication=jobapplicationRep.findById(idjobapplication).get();
		cv.setJobapplication(jobapplication);
		return cvRep.save(cv);
	}

	public CV addCVEducation(Long idcv, Long ideducation) 
	{
		CV cv=cvRep.findById(idcv).get();
		Education education=educationRep.findById(ideducation).get();
		cv.addEducation(education);
		return cvRep.save(cv);
	}

	public CV addCVExperience(Long idcv, Long idexperience) 
	{
		CV cv=cvRep.findById(idcv).get();
		Experience Experience=experienceRep.findById(idexperience).get();
		cv.addExperience(Experience);
		return cvRep.save(cv);
	}

	public CV addCVSkill(Long idcv, Long idskill) 
	{
		CV cv=cvRep.findById(idcv).get();
		Skill skill=skillRep.findById(idskill).get();
		cv.addSkill(skill);
		return cvRep.save(cv);
	}

}
