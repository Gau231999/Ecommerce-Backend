package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.service.UserService;

@CrossOrigin("/**")
@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/Get")
	public User GetUser(@RequestBody User user) 
	{
		return userService.UserGetByEmailAndPassword(user.getUserEmail(), user.getUserPassword());
	}
	
	@GetMapping("/GetAll")
	public List<User> GetAllUsers() 
	{
		return userService.UserGetAll();
	}
	
	@PostMapping("/Save")
	public User SaveUser(@RequestBody User user)
	{
		return userService.UserPost(user);	
	}
	
	@GetMapping("/DeleteAll")
	public String deleteAll()
	{
		return userService.UserDeleteAll();
	}
}
