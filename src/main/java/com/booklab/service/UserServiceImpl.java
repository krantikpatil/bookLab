package com.booklab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booklab.model.Registration;
import com.booklab.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public Registration userRegistration(Registration registration) {

		System.out.println("Inside user service.....");
		return userRepository.save(registration);
	}

}
