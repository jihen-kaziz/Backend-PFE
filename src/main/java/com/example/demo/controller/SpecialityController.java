package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Speciality;
import com.example.demo.services.SpecialityService;

@RestController
@RequestMapping("/api/specialities")
public class SpecialityController 
{
	@Autowired
	SpecialityService specialityServ;
	
	@PostMapping("/addSpeciality/{idjob}")
	public Speciality addSpeciality(@RequestBody Speciality speciality,@PathVariable Long idjob) 
	{
		return specialityServ.addSpeciality(speciality, idjob);
	}

}
