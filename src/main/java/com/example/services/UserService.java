package com.example.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.entities.User;
import com.example.controller.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);

	boolean checkEmail(UserRegistrationDto registrationDto);
}
