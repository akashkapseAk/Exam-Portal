package com.exam.daorep;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.User;

public interface UserRepositryDao extends JpaRepository<User, Integer>{

	public User findByUsername(String username);
}
