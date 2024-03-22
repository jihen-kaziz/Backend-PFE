package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Candidate;
import com.example.demo.services.CandidateService;

@RestController
public class CandidateController 
{	
	@Autowired
	CandidateService candidateServ;
	
	@PostMapping("/addCandidate")
	public Candidate addCandidate(@RequestBody Candidate candidate)
	{
	return candidateServ.addCandidate(candidate);
	}
	
	@PostMapping(value = "/updateCandidate/{idcandidate}")
	public Candidate updateCandidate(@RequestBody Candidate candidate,@PathVariable Long idcandidate) 
	{
		return candidateServ.updateCandidate(candidate, idcandidate);
	}
	
	@DeleteMapping(value = "/deleteCandidate/{idcandidate}")
	public String deleteCandidate(@PathVariable Long idcandidate) 
	{
		return candidateServ.deleteCandidate(idcandidate);
	}
}
