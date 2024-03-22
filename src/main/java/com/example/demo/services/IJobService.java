package com.example.demo.services;

import com.example.demo.entities.Job;

public interface IJobService 
{
	public Job addJob(Job job, Long idrecruiter);
}
