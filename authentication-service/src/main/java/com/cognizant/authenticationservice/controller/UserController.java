package com.cognizant.authenticationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.authenticationservice.model.Mentor;
import com.cognizant.authenticationservice.model.MentorSkills;
import com.cognizant.authenticationservice.model.Trainee;
import com.cognizant.authenticationservice.repository.MentorRepository;
import com.cognizant.authenticationservice.repository.RoleRepository;
import com.cognizant.authenticationservice.repository.UserRepository;
import com.cognizant.authenticationservice.security.AppUserDetailsService;
import com.cognizant.authenticationservice.service.UserService;

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
	
	@PostMapping("/mentor")
	public String signupMentor(@RequestBody Mentor mentor) throws UserAlreadyExistsException {
		return appUserDetailsService.signupMentor(mentor);

	}
	
	@PostMapping("/trainee")
	public String signupTrainee(@RequestBody Trainee trainee) throws UserAlreadyExistsException {
		return appUserDetailsService.signupTrainee(trainee);

	}
	

	@PostMapping("/mentor/{name}/{skillName}")
	public void addSkills(@PathVariable("name") String name,@PathVariable("skillName") String skillName, @RequestBody MentorSkills mentorSkills) throws UserAlreadyExistsException {
		 userService.addSkills(name,skillName,mentorSkills);

	}
	
	@GetMapping("/mentors")
	public List<Mentor> getMentors() {
		return mentorRepository.findAll();
	}
	
}
