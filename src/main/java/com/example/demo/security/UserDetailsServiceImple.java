package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserDetailsServiceImple implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@SuppressWarnings("unused")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getByUserName(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("Not Found User !!");
		}
		
		return new CustomUserDetails(user);
	}

}
