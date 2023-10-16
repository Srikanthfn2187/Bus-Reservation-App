package org.jsp.SpringBootDemo.dao;

import java.util.Optional;

import org.jsp.SpringBootDemo.dto.User;
import org.jsp.SpringBootDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao 
{
	@Autowired
	UserRepository repo;
	
	public User saveUser(User u)
	{
		return repo.save(u);
	}
	
	public User updateUser(User u)
	{
		return repo.save(u);
	}
	
	public Optional<User> findById(int userid)
	{
		return repo.findById(userid);
	}
	
	public Optional<User> verify(String email,String password)
	{
		return repo.verify(email,password);
	}
	
	public Optional<User> verify(long phone,String password)
	{
		return repo.verify(phone,password);
	}
}
