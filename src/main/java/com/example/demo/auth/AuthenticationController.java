package com.example.demo.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")  
@RequiredArgsConstructor
public class AuthenticationController 
{
	private final AuthenticationService authenticationServ;
	
	@PostMapping("/registerAdmin")
	public ResponseEntity<AuthenticationResponse> registerAdmin(@RequestBody RegisterRequest request) 
	{
	    return ResponseEntity.ok(authenticationServ.registerAdmin(request));
	}
	
	@PostMapping("/registerRecruiter")
	public ResponseEntity<AuthenticationResponse> registerRecruiter(@RequestBody RegisterRequest request) 
	{
	    return ResponseEntity.ok(authenticationServ.registerRecruiter(request));
	}
	
	@PostMapping("/registerCandidate")
	public ResponseEntity<AuthenticationResponse> registerCandidate(@RequestBody RegisterRequest request) 
	{
	    return ResponseEntity.ok(authenticationServ.registerCandidate(request));
	}
		
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) 
	{
	    return ResponseEntity.ok(authenticationServ.authenticate(request));
	}
}
