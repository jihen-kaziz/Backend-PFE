package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Job;
import com.example.demo.entities.Recruiter;
import com.example.demo.repository.IJobRepository;
import com.example.demo.repository.IRecruiterRepository;

@Service
public class JobService implements IJobService 
{
	@Autowired
	IJobRepository jobRep;
	
	@Autowired
	IRecruiterRepository recruiterRep;

	@Override
	public Job addJob(Job job, Long idrecruiter) 
	{
		Recruiter recruiter=recruiterRep.findById(idrecruiter).get();
		job.setRecruiter(recruiter);
		return jobRep.save(job);
	}

}
