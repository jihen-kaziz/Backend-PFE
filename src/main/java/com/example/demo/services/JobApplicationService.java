package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.JobApplicationDTO;
import com.example.demo.model.Candidate;
import com.example.demo.model.Job;
import com.example.demo.model.JobApplication;
import com.example.demo.model.User;
import com.example.demo.repository.IJobApplicationRepository;
import com.example.demo.repository.IJobRepository;
import com.example.demo.repository.IUserRepository;

@Service
public class JobApplicationService
{
	@Autowired
	IJobApplicationRepository jobapplicationRep;
	
	@Autowired
	IUserRepository userRep;
	
	@Autowired
	IJobRepository jobRep;

	public JobApplication addJobApplication(JobApplication jobapplication, Long idcandidate, Long idjob) 
	{
		Optional<User> user=userRep.findById(idcandidate);
		Candidate candidate= (Candidate) user.get();
		Job job=jobRep.findById(idjob).get();
		jobapplication.setCandidate(candidate);
		jobapplication.setJob(job);
		return jobapplicationRep.save(jobapplication);
	}
	
	public List<JobApplicationDTO> getAllJobApplications() 
	{
		List<JobApplication> jobApplications=jobapplicationRep.findAll();
		List<JobApplicationDTO> jobApplicationDTOs=jobApplications.stream()
																  .map(jobApplication -> {
																	  JobApplicationDTO dto = new JobApplicationDTO();
																	  dto.setId(jobApplication.getId());
																	  dto.setNumber(jobApplication.getNumber());
																	  return dto;
																  })
																  .collect(Collectors.toList());											  
		return jobApplicationDTOs;
	}
	
	public int getNumberOfJobApplications() 
	{
		List<JobApplication> jobApplications=jobapplicationRep.findAll();
		return jobApplications.size();
	}
	
	public List<JobApplicationDTO> getJobApplicationsByCandidateId(Long CandidateId) 
	{
        List<JobApplication> jobApplications=jobapplicationRep.findByCandidateId(CandidateId);
		List<JobApplicationDTO> jobApplicationDTOs=jobApplications.stream()
																  .map(jobApplication -> {
																	  JobApplicationDTO dto = new JobApplicationDTO();
																	  dto.setId(jobApplication.getId());
																	  dto.setNumber(jobApplication.getNumber());
																	  return dto;
																  })
																  .collect(Collectors.toList());											  
		return jobApplicationDTOs;
    }
	
	public List<JobApplicationDTO> getJobApplicationsByJobId(Long JobId) 
	{
        List<JobApplication> jobApplications=jobapplicationRep.findByJobId(JobId);
		List<JobApplicationDTO> jobApplicationDTOs=jobApplications.stream()
																  .map(jobApplication -> {
																	  JobApplicationDTO dto = new JobApplicationDTO();
																	  dto.setId(jobApplication.getId());
																	  dto.setNumber(jobApplication.getNumber());
																	  return dto;
																  })
																  .collect(Collectors.toList());											  
		return jobApplicationDTOs;
    }

	public JobApplication updateJobApplication(JobApplication jobapplication, Long idcandidate, Long idjobapplication) 
	{	
		JobApplication jobapplication2=jobapplicationRep.findById(idjobapplication).get();
				if(jobapplication2.getCandidate().getId().equals(idcandidate))
				{
					jobapplication2.setNumber(jobapplication.getNumber());
				}
		return jobapplicationRep.save(jobapplication2);
	}

	public String deleteJobApplication(Long idcandidate, Long idjobapplication) {
		String ch="";
		JobApplication jobapplication=jobapplicationRep.findById(idjobapplication).get();
		if(jobapplication.getCandidate().getId().equals(idcandidate))
		{
			jobapplicationRep.deleteById(idjobapplication);
			ch="Job Application successfulty deleted!!";
		}
		return ch;
	}
}
