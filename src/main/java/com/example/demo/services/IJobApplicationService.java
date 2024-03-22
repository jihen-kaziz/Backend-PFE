package com.example.demo.services;

import com.example.demo.entities.JobApplication;

public interface IJobApplicationService 
{
	public JobApplication addJobApplication(JobApplication jobapplication, Long idcandidate);
}
