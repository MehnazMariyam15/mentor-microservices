package com.cognizant.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.userservice.repository.MentorRepository;
import com.cognizant.userservice.repository.RoleRepository;
import com.cognizant.userservice.repository.UserRepository;
import com.cognizant.userservice.security.AppUserDetailsService;
import com.cognizant.userservice.service.UserService;

@RequestMapping("/signup")
@RestController
public class UserController {

	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	MentorRepository mentorRepository;

	@Autowired
	UserService userService;

}
