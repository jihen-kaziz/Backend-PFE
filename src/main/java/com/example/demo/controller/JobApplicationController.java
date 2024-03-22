package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.JobApplication;
import com.example.demo.services.JobApplicationService;

@RestController
public class JobApplicationController 
{
	@Autowired
	JobApplicationService jobapplicationServ;
	
	@PostMapping(value="/addJobApplication/{idcandidate}")
	public JobApplication addJobApplication(@RequestBody JobApplication jobapplication,@PathVariable Long idcandidate) 
	{
		return jobapplicationServ.addJobApplication(jobapplication, idcandidate);
	}
}
