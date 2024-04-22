package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Experience;
import com.example.demo.services.ExperienceService;

@RestController
@RequestMapping("/api/experiences")
public class ExperienceController 
{
	@Autowired
	ExperienceService experienceServ;
	
	@PostMapping("/addExperience")
	public Experience addExperience(@RequestBody Experience experience)
	{
	return experienceServ.addExperience(experience);
	}
}
