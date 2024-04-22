package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.auth.RegisterRequest;
import com.example.demo.model.Candidate;
import com.example.demo.model.Recruiter;
import com.example.demo.model.User;
import com.example.demo.services.AccountManagementService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/AccountsManagement")
@RequiredArgsConstructor
public class AccountManagementController 
{
	private final AccountManagementService accountManagementServ;
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() 
	{
		return accountManagementServ.getAllUsers();
	}
	
	@GetMapping("/getAllRecruiters")
	public List<Recruiter> getAllRecruiters()
	{
		return accountManagementServ.getAllRecruiters();
	}
	
	@GetMapping("/getAllCandidates")
	public List<Candidate> getAllCandidates()
	{
		return accountManagementServ.getAllCandidates();
	}
	
	@GetMapping("/getNumberOfRecruiters")
	public int getNumberOfRecruiters() 
	{
		return accountManagementServ.getNumberOfRecruiters();
	}
	
	@GetMapping("/getNumberOfCandidates")
	public int getNumberOfCandidates() 
	{
		return accountManagementServ.getNumberOfCandidates();
	}
	
	@GetMapping("/getUser/{id}")
	public User getUserById(@PathVariable("id") Long id) 
	{
		return accountManagementServ.getUserById(id);
	}
	
	@PostMapping("/updateUser/{id}")
	public User updateUser(@PathVariable("id") Long id,@RequestBody  RegisterRequest request) 
	{
		return accountManagementServ.updateUser(id, request);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable("id") Long id) 
	{
		accountManagementServ.deleteUser(id);
	}
}
