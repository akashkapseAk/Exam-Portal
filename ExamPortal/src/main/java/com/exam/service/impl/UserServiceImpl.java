package com.exam.service.impl;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.daorep.RoleRepositryDao;
import com.exam.daorep.UserRepositryDao;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;

//creating user
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepositryDao userRepositryDao;
	
	@Autowired
	private RoleRepositryDao roleRepositryDao;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
	User local=	this.userRepositryDao.findByUsername(user.getUsername());
		
		if(local!=null)
		{
			System.out.println("user is already there!!");
			throw new Exception();
		}
		else
		{
			//ek ek role nikalege q ki role kahi sare hoge 
			for(UserRole ur:userRoles)
			{
				roleRepositryDao.save(ur.getRole());
			}
			//usko nikala user ko set kiya kiya userrole mai
			user.getUserRoles().addAll(userRoles);
			local=this.userRepositryDao.save(user);
		}
		
		
		return local;
	}

	@Override
	public User getUser(String Username) {
	
		
		return this.userRepositryDao.findByUsername(Username);
	}

	@Override
	public void deleteById(int userid) {
		this.userRepositryDao.deleteById(userid);
		
	}

}
