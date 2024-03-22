package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Job;
import com.example.demo.services.JobService;

@RestController
public class JobController 
{
	@Autowired
	JobService jobServ;
	
	@PostMapping(value="/addJob/{idrecruiter}")
	public Job addJob(@RequestBody Job job,@PathVariable Long idrecruiter) 
	{
		return jobServ.addJob(job, idrecruiter);
	}
}
