package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.JwtRequest;
import com.example.demo.entities.JwtResponse;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.UserDetailsServiceImple;
import com.example.demo.service.jwt.JwtUtil;

@CrossOrigin("/**")
@RestController
public class JwtController {
	
	@Autowired 
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImple impleDetailsServiceImple;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/token",method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		UserDetails userDetails = this.impleDetailsServiceImple.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@RequestMapping(value = "/testing",method = RequestMethod.GET)
	public String test()
	{
		if(userRepository.getByUserName("panchalgausu17dse@student.mes.ac.in")==null)
		{
			com.example.demo.entities.User user = new com.example.demo.entities.User();
			user.setUserName("Gaurav");
			user.setUserAddress("Thane");
			user.setUserPassword("password");
			user.setUserEmail("panchalgausu17dse@student.mes.ac.in");
			user.setUserPhone("8097891247");
			user.setUserType("User");
			userRepository.save(user);
		}
		return "Tesing Without Jwt-Token Hit";
	}
}
