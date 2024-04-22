package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Skill;
import com.example.demo.repository.ISkillRepository;

@Service
public class SkillService
{
	@Autowired
	ISkillRepository skillRep;
	
	public Skill addSkill(Skill skill) {
		return skillRep.save(skill);
	}

}
