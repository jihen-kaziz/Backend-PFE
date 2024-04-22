package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.auth.RegisterRequest;
import com.example.demo.model.Candidate;
import com.example.demo.model.Recruiter;
import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountManagementService 
{		
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	private IUserRepository userRep;
	
	public List<User> getAllUsers() 
	{
		return userRep.findAll();
	}
	
	public List<Recruiter> getAllRecruiters()
	{
		return userRep.findAllRecruiters();
	}
	
	public List<Candidate> getAllCandidates()
	{
		return userRep.findAllCandidates();
	}
	
	public int getNumberOfRecruiters() 
	{
		List<Recruiter> recruiters=userRep.findAllRecruiters();
		return recruiters.size();
	}
	
	public int getNumberOfCandidates() 
	{
		List<Candidate> candidates=userRep.findAllCandidates();
		return candidates.size();
	}
	
	public User getUserById(Long id) 
	{
		Optional<User> user = userRep.findById(id);
		if(user.isPresent()) 
		{
			return user.get();
		}
		return null;
	}
	
	public User updateUser(Long id, RegisterRequest request) 
	{		
		User user=userRep.findById(id).get();
		user.setFirstname(request.getFirstname());
		user.setLastname(request.getLastname());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setPhone(request.getPhone());		
		return userRep.save(user);
	}
	
	public void deleteUser(Long id) 
	{
		userRep.deleteById(id);
	}
}
