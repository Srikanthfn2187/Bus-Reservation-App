package org.jsp.SpringBootDemo.service;

import java.util.Optional;

import org.jsp.SpringBootDemo.Exception.IdNotFoundException;
import org.jsp.SpringBootDemo.Exception.InvalidCredentialsException;
import org.jsp.SpringBootDemo.dao.AdminDao;
import org.jsp.SpringBootDemo.dto.Admin;
import org.jsp.SpringBootDemo.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Autowired
	private AdminDao dao;
	
	
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin)
	{
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		structure.setData(dao.saveAdmin(admin));
		structure.setMessage("Admin details are saved!!");
		structure.setStatuscode(HttpStatus.CREATED.value());
	    return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin)
	{
		ResponseStructure structure=new ResponseStructure<>();
		structure.setData(dao.updateAdmin(admin));
		structure.setMessage("Admin details are updated!!");
		structure.setStatuscode(HttpStatus.ACCEPTED.value());
	    return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> findById(int id)
	{
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		Optional<Admin> recAdmin=dao.findById(id);
		if(recAdmin.isPresent())
		{
			structure.setData(recAdmin.get());
			structure.setMessage("Admin details are found!!");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Admin>> verifyAdmin(long phone,String password)
	{
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		Optional<Admin> recAdmin=dao.verify(phone,password);
		if(recAdmin.isPresent())
		{
			structure.setData(recAdmin.get());
			structure.setMessage("Admin details are found!!");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}
	
	public ResponseEntity<ResponseStructure<Admin>> verifyAdmin(String email,String password)
	{
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		Optional<Admin> recAdmin=dao.verify(email,password);
		if(recAdmin.isPresent())
		{
			structure.setData(recAdmin.get());
			structure.setMessage("Admin details are found!!");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}
	
	

}
