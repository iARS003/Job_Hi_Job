package com.ars.jobhijob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ars.jobhijob.entity.User;
import com.ars.jobhijob.repository.UserRepository;

@Service
public class UserService 
{	
	@Autowired
	private UserRepository repo;
	
	public User register(User user)
	{
		return repo.save(user);
	}
	
	public User login (String username, String password)
	{
		return repo.findByUsernameAndPassword(username, password);
	}
	
	public User findByUsername(String username)
	{
		return repo.findByUsername(username);
	}
	
	public void updatePassword(User user)
	{
		repo.save(user);
	}
	
}
