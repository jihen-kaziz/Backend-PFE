package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Admin;
import com.example.demo.services.AdminService;

@RestController
public class AdminController 
{
	@Autowired
	AdminService adminServ;
	
	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin)
	{
	return adminServ.addAdmin(admin);
	}
	
	@PostMapping(value = "/updateAdmin/{idadmin}")
	public Admin updateAdmin(@RequestBody Admin admin,@PathVariable Long idadmin) 
	{
		return adminServ.updateAdmin(admin, idadmin);
	}
	
	@DeleteMapping(value = "/deleteAdmin/{idadmin}")
	public String deleteAdmin(@PathVariable Long idadmin) 
	{
		return adminServ.deleteAdmin(idadmin);
	}
}
