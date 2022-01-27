package com.example.demo.service.jwt;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalNotFoundException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.security.UserDetailsServiceImple;

@Service
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserDetailsServiceImple UserDetailsServiceImple;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String tokanheader = request.getHeader("Authorization");
		String jwt= null;
		String username=null;
		
		if(tokanheader!=null && tokanheader.startsWith("Bearer "))
		{
			jwt = tokanheader.substring(7);
			username = jwtUtil.extractUsername(jwt);
		}
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails userDetails = this.UserDetailsServiceImple.loadUserByUsername(username);
			try {
				UsernamePasswordAuthenticationToken authenticationToken = 
						new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		filterChain.doFilter(request, response);
		
	}
	
}
