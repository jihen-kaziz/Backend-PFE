package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.JobApplicationDTO;
import com.example.demo.model.JobApplication;
import com.example.demo.services.JobApplicationService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/jobApplications")
public class JobApplicationController 
{
	@Autowired
	JobApplicationService jobapplicationServ;
	
	@PostMapping("/addJobApplication/{idcandidate}/{idjob}")
	public JobApplication addJobApplication(@RequestBody JobApplication jobapplication,@PathVariable Long idcandidate,@PathVariable Long idjob) 
	{
		return jobapplicationServ.addJobApplication(jobapplication, idcandidate, idjob);
	}
	
	@GetMapping("/getAllJobApplications")
	public List<JobApplicationDTO> getAllJobApplications() {
		return jobapplicationServ.getAllJobApplications();
	}
	
	@GetMapping("/getNumberOfJobApplications")
	public int getNumberOfJobApplications() 
	{
		return jobapplicationServ.getNumberOfJobApplications();
	}
	
	@GetMapping("/getJobApplicationsByCandidateId/{CandidateId}")
	public List<JobApplicationDTO> getJobApplicationsByCandidateId(@PathVariable Long CandidateId) 
	{
		return jobapplicationServ.getJobApplicationsByCandidateId(CandidateId);
	}
	
	@GetMapping("/getJobApplicationsByJobId/{JobId}")
	public List<JobApplicationDTO> getJobApplicationsByJobId(@PathVariable Long JobId) 
	{
		return jobapplicationServ.getJobApplicationsByJobId(JobId);
	}
	
	@PostMapping("/updateJobApplication/{idcandidate}/{idjobapplication}")
	public JobApplication updateJobApplication(@RequestBody JobApplication jobapplication,@PathVariable Long idcandidate,@PathVariable Long idjobapplication) 
	{
		return jobapplicationServ.updateJobApplication(jobapplication, idcandidate, idjobapplication);
	}
	
	@DeleteMapping("/deleteJobApplication/{idcandidate}/{idjobapplication}")
	public String deleteJobApplication(@PathVariable Long idcandidate,@PathVariable Long idjobapplication)
	{
		return jobapplicationServ.deleteJobApplication(idcandidate, idjobapplication);
	}
}
