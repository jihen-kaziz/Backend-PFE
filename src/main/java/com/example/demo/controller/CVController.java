package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CV;
import com.example.demo.services.CVService;

@RestController
@RequestMapping("/api/cv")
public class CVController {
	@Autowired
	CVService CVServ;
	
	@PostMapping("/addCV/{idjobapplication}")
	public CV addCV(@RequestBody CV cv,@PathVariable Long idjobapplication) 
	{
		return CVServ.addCV(cv, idjobapplication);
	}
	
	@PostMapping("/addCVEducation/{idcv}/{ideducation}")
	public CV addCVEducation(@PathVariable Long idcv,@PathVariable Long ideducation) 
	{
		return CVServ.addCVEducation(idcv, ideducation);
	}
	
	@PostMapping("/addCVExperience/{idcv}/{idexperience}")
	public CV addCVExperience(@PathVariable Long idcv,@PathVariable Long idexperience) 
	{
		return CVServ.addCVExperience(idcv, idexperience);
	}
	
	@PostMapping("/addCVSkill/{idcv}/{idskill}")
	public CV addCVSkill(@PathVariable Long idcv,@PathVariable Long idskill) 
	{
		return CVServ.addCVSkill(idcv, idskill);
	}
	
}
