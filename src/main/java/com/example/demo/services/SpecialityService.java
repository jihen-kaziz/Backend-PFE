package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Job;
import com.example.demo.model.Speciality;
import com.example.demo.repository.IJobRepository;
import com.example.demo.repository.ISpecialityRepository;

@Service
public class SpecialityService
{
	@Autowired
	ISpecialityRepository specialityRep;
	
	@Autowired
	IJobRepository jobRep;
	
	public Speciality addSpeciality(Speciality speciality, Long idjob) 
	{
		Job job=jobRep.findById(idjob).get();
		speciality.setJob(job);
		return specialityRep.save(speciality);
	}
}
