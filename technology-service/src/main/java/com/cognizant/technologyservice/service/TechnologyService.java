package com.cognizant.technologyservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.technologyservice.model.Technology;
import com.cognizant.technologyservice.repository.TechnologyRepository;

@Service
public class TechnologyService {

	@Autowired
	TechnologyRepository technologyRepository;

	public List<Technology> getTechnologies() {
		return technologyRepository.findAll();
	}
}
