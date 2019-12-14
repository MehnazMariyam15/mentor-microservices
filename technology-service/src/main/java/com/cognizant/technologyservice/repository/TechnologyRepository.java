package com.cognizant.technologyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.technologyservice.model.Technology;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, String> {

}
