package com.cognizant.searchservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.searchservice.model.MentorSkills;

@Repository
public interface MentorSkillsRepository extends JpaRepository<MentorSkills, Long> {

	@Query(value = "select * from mentor_skill where ms_sk_id=?1", nativeQuery = true)
	public List<MentorSkills> getBySkillID(Long id);
}
