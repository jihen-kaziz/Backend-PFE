package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Experience;

@Repository
public interface IExperienceRepository extends JpaRepository<Experience, Long> 
{

}
