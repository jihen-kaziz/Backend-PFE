package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Candidate;
import com.example.demo.entities.JobApplication;
import com.example.demo.repository.ICandidateRepository;
import com.example.demo.repository.IJobApplicationRepository;

@Service
public class JobApplicationService implements IJobApplicationService 
{
	@Autowired
	IJobApplicationRepository jobapplicationRep;
	@Autowired
	ICandidateRepository candidateRep;

	@Override
	public JobApplication addJobApplication(JobApplication jobapplication, Long idcandidate) 
	{
		Candidate candidate=candidateRep.findById(idcandidate).get();
		jobapplication.setCandidate(candidate);
		return jobapplicationRep.save(jobapplication);
	}

}
