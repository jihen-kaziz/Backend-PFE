package com.example.demo.auth;

import java.util.HashMap;
import java.util.Map;

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
		Map<String, Object> extraClaims=new HashMap<>();
		extraClaims.put("id", admin.getId());
	    var jwtToken = jwtService.generateToken(extraClaims, admin);
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
		Map<String, Object> extraClaims=new HashMap<>();
		extraClaims.put("id", recruiter.getId());
	    var jwtToken = jwtService.generateToken(extraClaims, recruiter);
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
		Map<String, Object> extraClaims=new HashMap<>();
		extraClaims.put("id", candidate.getId());
	    var jwtToken = jwtService.generateToken(extraClaims, candidate);
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
		Map<String, Object> extraClaims=new HashMap<>();
		extraClaims.put("id", user.getId());
		var jwtToken = jwtService.generateToken(extraClaims, user);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}
}
