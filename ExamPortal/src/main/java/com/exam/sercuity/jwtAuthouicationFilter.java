package com.exam.sercuity;

import java.io.IOException;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.exam.service.serviceImpl.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class jwtAuthouicationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceimpl;
	
//	@Autowired
//	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String requesttokenheader = request.getHeader("Authorization");
		
		System.out.println(requesttokenheader);
		
		String username=null;
		String jwtToken=null;
		
		if(requesttokenheader!=null && requesttokenheader.startsWith("Bearer"))
		{
			jwtToken=requesttokenheader.substring(7);
			
			try {
			username=this.jwtUtil.extractUsername(jwtToken);
			}catch (ExpiredJwtException e) {
				e.printStackTrace();
				System.out.println("jwt token was expried");
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("error") ;
			}
		}
		else
		{
			System.out.println("invaild token not start bearer String");
		}
		
		//vailded
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
		 final	UserDetails userDetails = this.userDetailsServiceimpl.loadUserByUsername(username);
		 if(this.jwtUtil.validateToken(jwtToken, userDetails))
		 {
	UsernamePasswordAuthenticationToken upaf=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
	upaf.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			 SecurityContextHolder.getContext().setAuthentication(upaf);
		 }
		}
		else
		{
			System.out.println("token not vailed");
		}
		
		filterChain.doFilter(request, response);
	}
	         

	
}
