package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.JobDTO;
import com.example.demo.model.Job;
import com.example.demo.services.JobService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/jobs")
public class JobController 
{
	@Autowired
	JobService jobServ;
	
	@PostMapping("/addJob/{idrecruiter}")
	public Job addJob(@RequestBody Job job,@PathVariable Long idrecruiter) 
	{
		return jobServ.addJob(job, idrecruiter);
	}
	
	@GetMapping("/getAllJobs")
	public List<JobDTO> getAllJobs() 
	{
		return jobServ.getAllJobs();
	}
	
	@GetMapping("/getNumberOfJobs")
	public int getNumberOfJobs() 
	{
		return jobServ.getNumberOfJobs();
	}
	
	@GetMapping("/getJobsByRecruiterId/{idrecruiter}")
	public List<JobDTO> getJobsByRecruiterId(@PathVariable Long idrecruiter) 
	{
		return jobServ.getJobsByRecruiterId(idrecruiter);
	}
		
	@PostMapping("/updateJob/{idrecruiter}/{idjob}")
	public Job updateJob(@RequestBody Job job,@PathVariable Long idrecruiter,@PathVariable Long idjob) 
	{
		return jobServ.updateJob(job, idrecruiter, idjob);
	}
	
	@DeleteMapping("/deleteJob/{idrecruiter}/{idjob}")
	public void deleteJob(@PathVariable Long idrecruiter,@PathVariable Long idjob)
	{
		jobServ.deleteJob(idrecruiter, idjob);
	}
}
