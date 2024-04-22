package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString
@DiscriminatorValue("Recruiter")
public class Recruiter extends User 
{	
	@JsonIgnore
	@OneToMany(mappedBy = "recruiter", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<Job> listJobs = new ArrayList<>();
}
