package com.exam.daorep;




import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.Role;


public interface RoleRepositryDao  extends JpaRepository<Role, Integer>{

	
}
