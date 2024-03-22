package com.example.demo.services;

import com.example.demo.entities.Recruiter;

public interface IRecruiterService 
{
    public Recruiter addRecruiter(Recruiter recruiter);
	
	public Recruiter updateRecruiter(Recruiter recruiter,Long idrecruiter);
	
	public String deleteRecruiter(Long idrecruiter);

}
