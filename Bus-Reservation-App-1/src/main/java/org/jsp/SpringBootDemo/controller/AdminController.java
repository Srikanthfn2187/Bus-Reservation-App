package org.jsp.SpringBootDemo.controller;

import org.jsp.SpringBootDemo.dto.Admin;
import org.jsp.SpringBootDemo.dto.ResponseStructure;
import org.jsp.SpringBootDemo.service.AdminService;
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
public class AdminController 
{
	@Autowired
	private AdminService service;
	
	
	@PostMapping("/admins")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin a)
	{
		return service.saveAdmin(a);
	}
	
	@PutMapping("/admins")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin a)
	{
		return service.updateAdmin(a);
	}
	
	@GetMapping("/admins/{id}")
	public ResponseEntity<ResponseStructure<Admin>> verifyById(@PathVariable  int id)
	{
		return service.findById(id);
	}
	
	@PostMapping("/admins/verifybymail")
	public ResponseEntity<ResponseStructure<Admin>> verify(@RequestParam String email,@RequestParam String password)
	{
		return service.verifyAdmin(email, password);
	}
	
	@PostMapping("/admins/verifybyphone")
	public ResponseEntity<ResponseStructure<Admin>> verify(@RequestParam long phone,@RequestParam String password)
	{
		return service.verifyAdmin(phone, password);
	}
	
	
	
}
