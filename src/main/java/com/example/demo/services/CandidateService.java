package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Candidate;
import com.example.demo.repository.ICandidateRepository;

@Service
public class CandidateService implements ICandidateService 
{
	@Autowired
	ICandidateRepository candidateRep;
	
	@Override
	public Candidate addCandidate(Candidate candidate) 
	{
		return candidateRep.save(candidate);
	}
	
	@Override
	public Candidate updateCandidate(Candidate candidate, Long idcandidate) 
	{
		Candidate candidate2=candidateRep.findById(idcandidate).get();
		candidate2.setFirstname(candidate.getFirstname());
		candidate2.setLastname(candidate.getLastname());
		candidate2.setEmail(candidate.getEmail());
		candidate2.setPassword(candidate.getPassword());
		candidate2.setPhone(candidate.getPhone());
		return candidateRep.save(candidate2);
	}
	
	@Override
	public String deleteCandidate(Long idcandidate) 
	{
		String ch="";
		candidateRep.deleteById(idcandidate);
		ch="Candidate successfulty deleted!!";
		return ch ;
	}
}
