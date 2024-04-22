package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Experience;
import com.example.demo.repository.IExperienceRepository;

@Service
public class ExperienceService
{
	@Autowired
	IExperienceRepository experienceRep;
	
	public Experience addExperience(Experience experience) 
	{
		return experienceRep.save(experience);
	}

}
