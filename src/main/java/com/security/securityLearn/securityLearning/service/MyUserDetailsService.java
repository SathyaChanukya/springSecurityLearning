package com.security.securityLearn.securityLearning.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.security.securityLearn.securityLearning.Config.UserPrincipal;
import com.security.securityLearn.securityLearning.Entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.securityLearn.securityLearning.Repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= repo.findByUsername(username);
		
		if (user==null) {
			System.out.println("User Not Found");
			throw new UsernameNotFoundException("User Not Found");
		}
			 return new UserPrincipal(user);
		}
	}

