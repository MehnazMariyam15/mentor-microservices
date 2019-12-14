package com.cognizant.userservice.security;

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

import com.cognizant.userservice.repository.MentorRepository;
import com.cognizant.userservice.repository.RoleRepository;
import com.cognizant.userservice.repository.TraineeRepository;
import com.cognizant.userservice.repository.UserRepository;

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

}
