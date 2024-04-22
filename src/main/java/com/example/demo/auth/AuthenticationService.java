package com.example.demo.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.JwtService;
import com.example.demo.model.Admin;
import com.example.demo.model.Candidate;
import com.example.demo.model.Recruiter;
import com.example.demo.model.Role;
import com.example.demo.repository.IUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService 
{
	private final IUserRepository userRep;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	
	public AuthenticationResponse registerAdmin(RegisterRequest request) 
	{
		var admin=Admin.builder()
				.firstname(request.getFirstname())
		        .lastname(request.getLastname())
		        .email(request.getEmail())
		        .password(passwordEncoder.encode(request.getPassword()))
		        .phone(request.getPhone())
		        .role(Role.ADMIN)
		        .build();
		userRep.save(admin);
	    var jwtToken = jwtService.generateToken(admin);
	    return AuthenticationResponse.builder()
	    		.token(jwtToken)
	    		.build();
	}	
	
	public AuthenticationResponse registerRecruiter(RegisterRequest request) 
	{
		var recruiter=Recruiter.builder()
				.firstname(request.getFirstname())
		        .lastname(request.getLastname())
		        .email(request.getEmail())
		        .password(passwordEncoder.encode(request.getPassword()))
		        .phone(request.getPhone())
		        .role(Role.RECRUITER)
		        .build();
		userRep.save(recruiter);
	    var jwtToken = jwtService.generateToken(recruiter);
	    return AuthenticationResponse.builder()
	    		.token(jwtToken)
	    		.build();
	}
	
	public AuthenticationResponse registerCandidate(RegisterRequest request) 
	{
		var candidate=Candidate.builder()
				.firstname(request.getFirstname())
		        .lastname(request.getLastname())
		        .email(request.getEmail())
		        .password(passwordEncoder.encode(request.getPassword()))
		        .phone(request.getPhone())
		        .role(Role.CANDIDATE)
		        .build();
		userRep.save(candidate);
	    var jwtToken = jwtService.generateToken(candidate);
	    return AuthenticationResponse.builder()
	    		.token(jwtToken)
	    		.build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) 
	{
		authenticationManager.authenticate(	
		        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
		);
		var user = userRep.findByEmail(request.getEmail())
		        .orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}
}
