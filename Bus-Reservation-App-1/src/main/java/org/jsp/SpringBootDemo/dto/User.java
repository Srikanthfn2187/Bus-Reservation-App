package org.jsp.SpringBootDemo.dto;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(nullable = false)
	private String name;
	
	
	@Column(nullable = false,unique = true)
	private long  phone;
	
	
	@Column(nullable = false,unique = true)
	private String email;
	
	
	@Column(nullable = false)
	private String password;
	
	
	@Column(nullable = false,unique = true)
	private long aadhar;
	
	
	@Column(name="Date Of Birth",nullable = false)
	private String dob;
	
	
	@OneToMany(mappedBy = "user")
	private List<Ticket> tickets;
	
}
