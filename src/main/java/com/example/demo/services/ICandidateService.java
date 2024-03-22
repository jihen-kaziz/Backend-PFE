package com.example.demo.services;

import com.example.demo.entities.Candidate;

public interface ICandidateService 
{
	public Candidate addCandidate(Candidate candidate);
	
	public Candidate updateCandidate(Candidate candidate,Long idcandidate);
	
	public String deleteCandidate(Long idcandidate);
}
