package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Education;
import com.example.demo.repository.IEducationRepository;

@Service
public class EducationService
{
	@Autowired
	IEducationRepository educationRep;

	public Education addEducation(Education education) {
		return educationRep.save(education);
	}
	
	
}
