package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.JobDTO;
import com.example.demo.model.Job;
import com.example.demo.model.Recruiter;
import com.example.demo.model.User;
import com.example.demo.repository.IJobRepository;
import com.example.demo.repository.IUserRepository;

@Service
public class JobService
{
	@Autowired
	IJobRepository jobRep;
	
	@Autowired
	IUserRepository userRep;

	public Job addJob(Job job, Long idrecruiter) 
	{
		Optional<User> user=userRep.findById(idrecruiter);
		Recruiter recruiter=(Recruiter) user.get();
		job.setRecruiter(recruiter);
		return jobRep.save(job);
	}
	
	public List<JobDTO> getAllJobs() 
	{
		List<Job> jobs = jobRep.findAll();
		List<JobDTO> jobDTOs = jobs.stream()
				 				   .map(job -> {
				 					   JobDTO dto = new JobDTO();
                    				   dto.setId(job.getId());
                    				   dto.setCompany(job.getCompany());
                    				   dto.setTitle(job.getTitle());
                    				   dto.setType(job.getType());
                    				   dto.setSalary(job.getSalary());
                    				   dto.setDescription(job.getDescription());
                    				   return dto;
				 				   })
				 				   .collect(Collectors.toList());
		return jobDTOs;
	}
	
	public int getNumberOfJobs() 
	{
		List<Job> jobs=jobRep.findAll();
		return jobs.size();
	}
	
	public List<JobDTO> getJobsByRecruiterId(Long idrecruiter) 
	{
		List<Job> jobs = jobRep.findByRecruiterId(idrecruiter);
	    List<JobDTO> jobDTOs = jobs.stream()
	                               .map(job -> {
	                                   JobDTO dto = new JobDTO();
	                                   dto.setId(job.getId());
	                                   dto.setCompany(job.getCompany());
	                                   dto.setTitle(job.getTitle());
	                                   dto.setType(job.getType());
	                                   dto.setSalary(job.getSalary());
	                                   dto.setDescription(job.getDescription());
	                                   return dto;
	                               })
	                               .collect(Collectors.toList());
	    return jobDTOs;
    }

	public Job updateJob(Job job, Long idrecruiter, Long idjob) 
	{
		Job job2=jobRep.findById(idjob).get();
			if(job2.getRecruiter().getId().equals(idrecruiter))
			{
				job2.setCompany(job.getCompany());
				job2.setTitle(job.getTitle());
				job2.setType(job.getType());
				job2.setSalary(job.getSalary());
				job2.setDescription(job.getDescription());
			}
		return jobRep.save(job2);
	}

	public void deleteJob(Long idrecruiter, Long idjob) 
	{
		Job job=jobRep.findById(idjob).get();
		if(job.getRecruiter().getId().equals(idrecruiter))
		{
			jobRep.deleteById(idjob);
		}
	}
}
