package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Education;
import com.example.demo.services.EducationService;

@RestController
@RequestMapping("/api/educations")
public class EducationController 
{
	@Autowired
	EducationService educationServ;
	
	@PostMapping("/addEducation")
	public Education addEducation(@RequestBody Education education)
	{
	return educationServ.addEducation(education);
	}
}
