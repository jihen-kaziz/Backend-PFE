package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entities.Recruiter;
import com.example.demo.repository.IRecruiterRepository;

@Service
public class RecruiterService implements IRecruiterService 
{
	@Autowired
	IRecruiterRepository recruiterRep;

	@Override
	public Recruiter addRecruiter(Recruiter recruiter) 
	{
		return recruiterRep.save(recruiter);
	}

	@Override
	public Recruiter updateRecruiter(Recruiter recruiter, Long idrecruiter) 
	{
		Recruiter recruiter2=recruiterRep.findById(idrecruiter).get();
		recruiter2.setFirstname(recruiter.getFirstname());
		recruiter2.setLastname(recruiter.getLastname());
		recruiter2.setEmail(recruiter.getEmail());
		recruiter2.setPassword(recruiter.getPassword());
		recruiter2.setPhone(recruiter.getPhone());
		return recruiterRep.save(recruiter2);
	}
	
	@Override
	public String deleteRecruiter(Long idrecruiter) 
	{
		String ch="";
		recruiterRep.deleteById(idrecruiter);
		ch="Recruiter successfulty deleted!!";
		return ch ;
	}
}
