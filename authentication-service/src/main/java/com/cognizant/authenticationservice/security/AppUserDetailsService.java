package com.cognizant.authenticationservice.security;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.authenticationservice.model.Mentor;
import com.cognizant.authenticationservice.model.Role;
import com.cognizant.authenticationservice.model.Trainee;
import com.cognizant.authenticationservice.model.User;
import com.cognizant.authenticationservice.repository.MentorRepository;
import com.cognizant.authenticationservice.repository.MentorSkillsRepository;
import com.cognizant.authenticationservice.repository.RoleRepository;
import com.cognizant.authenticationservice.repository.TechnologyRepository;
import com.cognizant.authenticationservice.repository.TraineeRepository;
import com.cognizant.authenticationservice.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	MentorRepository mentorRepository;

	@Autowired
	TraineeRepository traineeRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	MentorSkillsRepository mentorSkillsRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDetailsService.class);

	public AppUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Bean
	public PasswordEncoder encodePassword() {
		LOGGER.info("Start");
		return new BCryptPasswordEncoder();
	}

	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		LOGGER.info("Start of loadUserByUsername");
		LOGGER.debug("UserRepository:{}", userRepository);
		userRepository.findByUserID(user);
		LOGGER.debug("User:{}", user);

		if (user == null) {
			throw new UsernameNotFoundException("Username not found");
		}

		else {
			AppUser appUser = new AppUser(userRepository.findByUserID(user));
			return appUser;
		}
	}

	public String signupMentor(Mentor signedMentor) throws UserAlreadyExistsException {
		LOGGER.info("Start of signupTrainee");
		System.err.println("signed Trainee" + signedMentor);
		Mentor mentorCheck = mentorRepository.findByUserID(signedMentor.getUserID());
		if (mentorCheck == null) {
			signedMentor.setPassword(encodePassword().encode(signedMentor.getPassword()));
			mentorRepository.save(signedMentor);
			User user = new User();
			user.setUserID(signedMentor.getUserID());
			user.setPassword(signedMentor.getPassword());
			Role role = roleRepository.findByName("MENTOR");
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			user.setRoleList(roles);
			userRepository.save(user);
			return "true";

		} else {
			return "false";

		}
	}

	public String signupTrainee(Trainee signedTrainee) throws UserAlreadyExistsException {
		LOGGER.info("Start of signupTrainee");
		System.err.println("signed Trainee" + signedTrainee);
		Trainee traineeCheck = traineeRepository.findByUserID(signedTrainee.getUserID());
		if (traineeCheck == null) {
			signedTrainee.setPassword(encodePassword().encode(signedTrainee.getPassword()));
			signedTrainee.setConfirmPassword(encodePassword().encode(signedTrainee.getConfirmPassword()));
			traineeRepository.save(signedTrainee);
			User user = new User();
			user.setUserID(signedTrainee.getUserID());
			user.setPassword(signedTrainee.getPassword()); 
			Role role = roleRepository.findByName("TRAINEE");
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			user.setRoleList(roles);
			userRepository.save(user);
			return "true";

		} else {
			return "false";

		}

	}
}
