package com.exam.service;

import java.util.Set;



import com.exam.model.User;
import com.exam.model.UserRole;


public interface UserService   {

	//creating user
	
		public User createUser(User user,Set<UserRole> userRoles) throws Exception;
		
		
		//get USer by username
		
		public User getUser(String Username);
		
		//deleteb by id username
		
		public  void deleteById(int userid);
}
