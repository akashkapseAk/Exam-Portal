package com.exam.controller;

import java.util.HashSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User creatUser(@RequestBody User user) throws Exception 
	{
		//set role karegeb means kis kis ko role mila hai 
		
		user.setProfile("default.png");
		Set<UserRole> Roles=new HashSet<>();
		//role ko set karege
		Role role=new Role();
		role.setRoleid(45);
		role.setRoleName("NORMAL");
		
		
		//user role set karege
		
		UserRole role2=new UserRole();
		role2.setUser(user);
		role2.setRole(role);
		
		Roles.add(role2);
		
		//set mai role ko add kare user role mai
		return this.userService.createUser(user, Roles);
		
	}
	
	//how to get all user but 1st go to Userservice for method
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) 
	{
		return this.userService.getUser(username);
		
	}
	
	//how to delete id phele method bano  Userservice mai
	
	@DeleteMapping("/{userid}")
	public void deleteUser(@PathVariable ("userid") int userid)
	{
		this.userService.deleteById(userid);
	}
	
	//update mai karuga
	
}
