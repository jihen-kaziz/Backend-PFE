package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.JobApplication;

@Repository
public interface IJobApplicationRepository extends JpaRepository<JobApplication, Long> 
{
	List<JobApplication> findByCandidateId(Long CandidateId);
	List<JobApplication> findByJobId(Long JobId);
}
