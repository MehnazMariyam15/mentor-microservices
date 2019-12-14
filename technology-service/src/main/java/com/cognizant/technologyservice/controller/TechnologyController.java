package com.cognizant.technologyservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.technologyservice.model.Technology;
import com.cognizant.technologyservice.service.TechnologyService;

@RestController
@RequestMapping("/technologies")
public class TechnologyController {

	@Autowired
	TechnologyService technologyService;
	
	@GetMapping("")
	public List<Technology> getTechnologies() {
		return technologyService.getTechnologies();
	}
}
