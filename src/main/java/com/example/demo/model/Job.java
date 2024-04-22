package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "jobs")
public class Job 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String company;
	private String title;
	private String type;
	private String salary;
	private String description;
	
	@ManyToOne
	@JoinColumn
	private Recruiter recruiter;
	
	@JsonIgnore
	@OneToMany(mappedBy = "job", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<JobApplication> listJobApplications = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "job", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<Speciality> listSpecialties = new ArrayList<>();
}
