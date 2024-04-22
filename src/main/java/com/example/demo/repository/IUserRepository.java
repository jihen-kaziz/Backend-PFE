package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Candidate;
import com.example.demo.model.Recruiter;
import com.example.demo.model.User;

public interface IUserRepository extends JpaRepository<User, Long> 
{
	Optional<User> findByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE TYPE(u) = Recruiter")
    List<Recruiter> findAllRecruiters();
	
	@Query("SELECT u FROM User u WHERE TYPE(u) = Candidate")
    List<Candidate> findAllCandidates();
}
