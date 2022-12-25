package com.booklab.confige;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.booklab.model.Registration;
import com.booklab.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService{
    
	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Registration user =userRepo.getUserByUserName(username);
			
		return  new CustomUserDetails(user);
	}

}
