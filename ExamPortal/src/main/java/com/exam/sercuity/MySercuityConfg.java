 package com.exam.sercuity;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.exam.service.serviceImpl.UserDetailsServiceImpl;



@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySercuityConfg extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private JwtAutEntryPoint unautoriseHandler;
	
	@Autowired
	private UserDetailsServiceImpl detailsServiceImpl;
	
	@Autowired
	private jwtAuthouicationFilter jwtauthouicationFilter;
	
	
	
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return  NoOpPasswordEncoder.getInstance();
		
	}
	
	@Override 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.detailsServiceImpl).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http   
		           .csrf()
		           .disable()
		           .cors()
		           .disable()
		           .authorizeRequests()
		           .antMatchers("/generate-token","/user/").permitAll()
		           .antMatchers(HttpMethod.OPTIONS).permitAll()
		           .anyRequest().authenticated()
		           .and()
		           .exceptionHandling().authenticationEntryPoint(unautoriseHandler)
		           .and()
		           .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		           http.addFilterBefore(jwtauthouicationFilter, UsernamePasswordAuthenticationFilter.class);
		       
		         
	}

}
