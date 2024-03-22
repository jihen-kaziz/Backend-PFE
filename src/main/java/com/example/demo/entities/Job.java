package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@Column(name = "id_job")
	private Long idjob;
	private String company;
	private String title;
	private String type;
	private String salary;
	private String description;
	
	@ManyToOne
	private Recruiter recruiter;
	@OneToMany(mappedBy = "job")
	private List<JobApplication> listJobApplication = new ArrayList<>();
}
