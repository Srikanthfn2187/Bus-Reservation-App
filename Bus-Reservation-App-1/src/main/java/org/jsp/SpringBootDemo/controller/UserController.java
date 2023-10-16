package org.jsp.SpringBootDemo.controller;

import org.jsp.SpringBootDemo.dto.ResponseStructure;
import org.jsp.SpringBootDemo.dto.User;
import org.jsp.SpringBootDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController 
{

	@Autowired
	private UserService service;
	
	
	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User a)
	{
		return service.saveUser(a);
	}
	
	@PutMapping("/users")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User a)
	{
		return service.updateUser(a);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> verifybyId(@PathVariable  int id)
	{
		return service.findById(id);
	}
	
	@PostMapping("/users/verifybymail")
	public ResponseEntity<ResponseStructure<User>> verify(@RequestParam String email,@RequestParam String password)
	{
		return service.verifyUser(email, password);
	}
	
	@PostMapping("/users/verifybyphone")
	public ResponseEntity<ResponseStructure<User>> verify(@RequestParam long phone,@RequestParam String password)
	{
		return service.verifyUser(phone, password);
	}
	
}
