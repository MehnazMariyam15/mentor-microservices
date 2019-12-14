package com.cognizant.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.userservice.model.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, String>{

	@Query("FROM Mentor m WHERE m.userID=?1")
	public Mentor findByUserID(String user);
	
	@Query("FROM Mentor m WHERE m.id=?1")
	public Mentor findByMentorId(Long id);
}
