package org.jsp.SpringBootDemo.service;

import java.util.Optional;

import org.jsp.SpringBootDemo.Exception.IdNotFoundException;
import org.jsp.SpringBootDemo.Exception.InvalidCredentialsException;
import org.jsp.SpringBootDemo.dao.UserDao;
import org.jsp.SpringBootDemo.dto.User;
import org.jsp.SpringBootDemo.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user)
	{
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setData(dao.saveUser(user));
		structure.setMessage("User details are saved!!");
		structure.setStatuscode(HttpStatus.CREATED.value());
	    return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<User>> updateUser(User user)
	{
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setData(dao.updateUser(user));
		structure.setMessage("User details are updated!!");
		structure.setStatuscode(HttpStatus.ACCEPTED.value());
	    return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<User>> findById(int id)
	{
		ResponseStructure<User> structure=new ResponseStructure<>();
		Optional<User> recUser=dao.findById(id);
		if(recUser.isPresent())
		{
			structure.setData(recUser.get());
			structure.setMessage("User details are found!!");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<User>> verifyUser(long phone,String password)
	{
		ResponseStructure<User> structure=new ResponseStructure<>();
		Optional<User> recUser=dao.verify(phone,password);
		if(recUser.isPresent())
		{
			structure.setData(recUser.get());
			structure.setMessage("User details are found!!");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}
	
	public ResponseEntity<ResponseStructure<User>> verifyUser(String email,String password)
	{
		ResponseStructure<User> structure=new ResponseStructure<>();
		Optional<User> recUser=dao.verify(email,password);
		if(recUser.isPresent())
		{
			structure.setData(recUser.get());
			structure.setMessage("User details are found!!");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}
}
