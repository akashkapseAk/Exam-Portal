package com.exam.service.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.daorep.UserRepositryDao;
import com.exam.model.User;




@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepositryDao userRepositryDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	User user = this.userRepositryDao.findByUsername(username);
	
	if(user==null)
	{
		throw new UsernameNotFoundException("no User found");
	}
		
		return user;
	}

}
