package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Admin;
import com.example.demo.repository.IAdminRepository;

@Service
public class AdminService implements IAdminService 
{	
	@Autowired
	IAdminRepository adminRep;

	@Override
	public Admin addAdmin(Admin admin) 
	{
		return adminRep.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin, Long idadmin) 
	{
		Admin admin2=adminRep.findById(idadmin).get();
		admin2.setFirstname(admin.getFirstname());
		admin2.setLastname(admin.getLastname());
		admin2.setEmail(admin.getEmail());
		admin2.setPassword(admin.getPassword());
		admin2.setPhone(admin.getPhone());
		return adminRep.save(admin2);
	}
	
	@Override
	public String deleteAdmin(Long idadmin) 
	{
		String ch="";
		adminRep.deleteById(idadmin);
		ch="Admin successfulty deleted!!";
		return ch ;
	}
	
	
}
