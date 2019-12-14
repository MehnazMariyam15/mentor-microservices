package com.cognizant.authenticationservice.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.authenticationservice.model.MentorSkills;

@Repository
public interface MentorSkillsRepository extends JpaRepository<MentorSkills, Long> {
	
	@Query("FROM MentorSkills ms WHERE ms.mentorId=?1")
	public Set<MentorSkills> getBySkillID(Long id);
}
