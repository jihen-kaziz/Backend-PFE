package com.example.demo.services;

import com.example.demo.entities.Admin;


public interface IAdminService 
{
    public Admin addAdmin(Admin admin);
	
	public Admin updateAdmin(Admin admin,Long idadmin);
	
	public String deleteAdmin(Long idadmin);
}
