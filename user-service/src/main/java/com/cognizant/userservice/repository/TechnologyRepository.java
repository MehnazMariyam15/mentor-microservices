package com.cognizant.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.userservice.model.Technology;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, String> {

	@Query("FROM Technology s WHERE s.skillName=?1")
	public Technology findBySkillName(String name);

}
