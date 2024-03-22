package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Recruiter;
import com.example.demo.services.RecruiterService;

@RestController
public class RecruiterController 
{	
	@Autowired
	RecruiterService recruiterServ;
	
	@PostMapping("/addRecruiter")
	public Recruiter addRecruiter(@RequestBody Recruiter recruiter)
	{
	return recruiterServ.addRecruiter(recruiter);
	}
	
	@PostMapping(value = "/updateRecruiter/{idrecruiter}")
	public Recruiter updateRecruiter(@RequestBody Recruiter recruiter,@PathVariable Long idrecruiter) 
	{
		return recruiterServ.updateRecruiter(recruiter, idrecruiter);
	}
	
	@DeleteMapping(value = "/deleteRecruiter/{idrecruiter}")
	public String deleteRecruiter(@PathVariable Long idrecruiter) 
	{
		return recruiterServ.deleteRecruiter(idrecruiter);
	}
}
