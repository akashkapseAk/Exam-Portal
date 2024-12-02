package com.exam.controller;

import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.JwtRequest;
import com.exam.model.JwtResponse;
import com.exam.model.User;
import com.exam.sercuity.JwtUtils;
import com.exam.service.serviceImpl.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl detailsServiceimpl;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	
	//genrate token
	
	@PostMapping("/generate-token")
	@CrossOrigin("*")
	public ResponseEntity<?> genreateToken(@RequestBody JwtRequest jwtRequest) throws Throwable 
	{
		try { 
			
			authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
			
		} catch (UsernameNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("user not found");
		}
		
	UserDetails userDetails = this.detailsServiceimpl.loadUserByUsername(jwtRequest.getUsername());
	String token = this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
		
		
	}
	
	
	public void authenticate(String username,String password) throws Exception
	{
		
		try {
			 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			// TODO: handle exception
			
			throw  new Exception("User Disbale"+e.getMessage());
		}catch (BadCredentialsException e) {
			// TODO: handle exception
			 throw new Exception("Invailed crediton"+e.getMessage());
		}
	}
	
	
	
	//angular use bande fetch karege jo current user hai
	//return the deatils of current user
	@GetMapping("/currentuser")
	public User getCurrentUser(Principal principal)
	{
		
		return (User) this.detailsServiceimpl.loadUserByUsername(principal.getName());
		
	}
}
