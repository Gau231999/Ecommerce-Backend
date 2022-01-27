package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User UserPost(User user)
	{
		return userRepository.save(user);
	}
	
	public User UserGet(Integer id)
	{
		return userRepository.findById(id).get();
	}
	
	public List<User> UserGetAll()
	{
		return userRepository.findAll();
	}
	
	public User UserGetByEmailAndPassword(String email,String password)
	{
		return userRepository.findByUserEmailAndUserPassword(email, password);
	}
	
	
	public String UserDeleteAll()
	{
		userRepository.deleteAll();
		return "All Data Has Been Deleted";
	}
}
	
	
