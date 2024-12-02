package com.exam;

//import java.util.HashSet;
//
//
//import java.util.Set;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.exam.model.Role;
//import com.exam.model.User;
//import com.exam.model.UserRole;
//import com.exam.service.UserService;

@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner{
	
//	@Autowired
//	private UserService service;

	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//user set kar rhe 
//		User user=new User();
//		user.setUsername("arya");
//		user.setPassword("abc");
//		user.setFirstname("akash");
//		user.setLastname("kapse");
//		user.setEmail("arya@gmail.com");
//		user.setPhone("9922");
//		user.setProfile("default.png");
//		//role se kar rhe hai 
//		Role role1=new Role();
//		role1.setRoleid(44);
//		role1.setRoleName("ADMIN");
//		
//		//ab user ko role set karege 
//		
//		Set<UserRole> userRoleset=new HashSet<>();
//		
//		 UserRole userole=new UserRole();
//		 userole.setRole(role1);
//         userole.setUser(user);
//         
//         
//         //konse user mai dalna hai usko set karege
//         userRoleset.add(userole);
//         
//         User createUser = this.service.createUser(user, userRoleset);
//         System.out.println(createUser.getUsername());
	}

}
