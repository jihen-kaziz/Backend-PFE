package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class CV 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String number;
	
	@ManyToOne
	@JoinColumn(name = "jobapplication_id")
	private JobApplication jobapplication;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "cv_educations",
    joinColumns = @JoinColumn(name="cv_id"),
    inverseJoinColumns = @JoinColumn(name="education_id"))
	private List<Education> listEducations = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "cv_experiences",
    joinColumns = @JoinColumn(name="cv_id"),
    inverseJoinColumns = @JoinColumn(name="experience_id"))
	private List<Experience> listExperiences = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "cv_skills",
    joinColumns = @JoinColumn(name="cv_id"),
    inverseJoinColumns = @JoinColumn(name="skill_id"))
	private List<Skill> listSkills = new ArrayList<>();
	
	public void addEducation(Education education)
	{
		this.listEducations.add(education);
	}
	
	public void addExperience(Experience experience)
	{
		this.listExperiences.add(experience);
	}
	
	public void addSkill(Skill skill)
	{
		this.listSkills.add(skill);
	}
}
