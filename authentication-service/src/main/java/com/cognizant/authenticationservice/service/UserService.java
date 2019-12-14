package com.cognizant.authenticationservice.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.authenticationservice.model.Mentor;
import com.cognizant.authenticationservice.model.MentorSkills;
import com.cognizant.authenticationservice.model.Technology;
import com.cognizant.authenticationservice.repository.MentorRepository;
import com.cognizant.authenticationservice.repository.MentorSkillsRepository;
import com.cognizant.authenticationservice.repository.TechnologyRepository;

@Service
public class UserService {

	@Autowired
	TechnologyRepository technologyRepository;
	@Autowired
	MentorRepository mentorRepository;
	@Autowired
	MentorSkillsRepository mentorSkillsRepository;

	public void addSkills(String mentorName, String skillName, MentorSkills mentorSkills)
			throws UserAlreadyExistsException {
		Technology skills = technologyRepository.findBySkillName(skillName);
		Mentor mentor = mentorRepository.findByUserID(mentorName);
		mentorSkills.setMentorId(mentor);
		mentorSkills.setSkillId(skills);
		Set<MentorSkills> list = mentor.getMentorSkillsList();

		list.add(mentorSkills);
		mentor.setMentorSkillList(list);
		mentorRepository.save(mentor);
		mentorSkillsRepository.save(mentorSkills);

	}

}
