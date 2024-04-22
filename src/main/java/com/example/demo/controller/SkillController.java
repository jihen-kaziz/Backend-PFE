package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Skill;
import com.example.demo.services.SkillService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/skills")
public class SkillController 
{
	@Autowired
	SkillService skillServ;
	
	@PostMapping("/addSkill")
	public Skill addSkill(@RequestBody Skill skill) 
	{	
		return skillServ.addSkill(skill);
	}
	
}
