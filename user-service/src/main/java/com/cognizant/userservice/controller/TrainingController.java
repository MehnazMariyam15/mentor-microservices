package com.cognizant.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.userservice.model.Training;
import com.cognizant.userservice.service.TrainingService;

@RestController
@RequestMapping("/proposal")
public class TrainingController {

	@Autowired
	TrainingService trainingService;

	@PostMapping("/{mentorName}/{traineeName}/{techName}")
	public void setProposalStatus(@PathVariable("mentorName") String mentorName,
			@PathVariable("traineeName") String traineeName, @PathVariable("techName") String techName) {
		System.out.println(" " + mentorName + " " + traineeName + " " + techName);
		trainingService.setProposalStatus(mentorName, traineeName, techName);
	}

	@GetMapping("/pending/{mentorName}")
	public List<Training> getPendingList(@PathVariable("mentorName") String mentorName) {
		return trainingService.getPendingList(mentorName);
	}

	@GetMapping("/all/{mentorName}")
	public List<Training> getAllTrainingList(@PathVariable("mentorName") String mentorName) {
		return trainingService.getMentorList(mentorName);
	}

	@GetMapping("/alll/{traineeName}")
	public List<Training> getAllMentorList(@PathVariable("traineeName") String traineeName) {
		return trainingService.getMentorsList(traineeName);
	}

	@PutMapping("/accept/{trainingId}")
	public void getAcceptedList(@PathVariable("trainingId") String trainingId) {
		Long id = new Long(trainingId);
		trainingService.AcceptedList(id);
	}

	@DeleteMapping("/decline/{traineeId}")
	public void declineRequest(@PathVariable("traineeId") String trainingId) {
		Long id = new Long(trainingId);
		trainingService.declineRequest(id);
	}

}
