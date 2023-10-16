package org.jsp.SpringBootDemo.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.SpringBootDemo.dto.Admin;
import org.jsp.SpringBootDemo.dto.Bus;
import org.jsp.SpringBootDemo.repository.Adminrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao 
{
	@Autowired
	Adminrepository repo;
	
	public Admin saveAdmin(Admin a)
	{
		return repo.save(a);
	}
	
	public Admin updateAdmin(Admin a)
	{
		return repo.save(a);
	}
	
	public Optional<Admin> findById(int adminid)
	{
		return repo.findById(adminid);
	}
	
	public Optional<Admin> verify(String email,String password)
	{
		return repo.verify(email,password);
	}
	
	public Optional<Admin> verify(long phone,String password)
	{
		return repo.verify(phone,password);
	}

	

	
	
}
