package com.cognizant.userservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.userservice.model.Training;
import com.cognizant.userservice.repository.MentorRepository;
import com.cognizant.userservice.repository.TrainingRepository;
import com.cognizant.userservice.repository.TechnologyRepository;
import com.cognizant.userservice.repository.TraineeRepository;

@Service
public class TrainingService {

	@Autowired
	TrainingRepository trainingRepository;

	@Autowired
	MentorRepository mentorRepository;

	@Autowired
	TraineeRepository traineeRepository;

	@Autowired
	TechnologyRepository TechnologyRepository;

	@Transactional
	public void setProposalStatus(String mentorName, String traineeName, String techName) {
		Training training = new Training();
		training.setMentorId(mentorRepository.findByUserID(mentorName));
		training.setTraineeId(traineeRepository.findByUserID(traineeName));
		training.setTechId(TechnologyRepository.findBySkillName(techName));
		training.setProposalStatus("PENDING");
		trainingRepository.save(training);
	}

	@Transactional
	public List<Training> getPendingList(String mentorName) {
		Long id = mentorRepository.findByUserID(mentorName).getId();
		return trainingRepository.getPendingList(id);
	}

	@Transactional
	public List<Training> getAllTrainingList(String mentorName) {

		return trainingRepository.findAll();
	}

	@Transactional
	public void AcceptedList(Long trainingId) {
		Training training = this.trainingRepository.findAllById(trainingId);
		training.setProposalStatus("APPROVED");
		this.trainingRepository.save(training);
	}

	public void declineRequest(Long trainingId) {
		Training training = this.trainingRepository.findAllById(trainingId);

		this.trainingRepository.delete(training);

	}

	@Transactional
	public List<Training> getMentorList(String mentorName) {
		Long id = mentorRepository.findByUserID(mentorName).getId();
		return trainingRepository.getMentorList(id);
	}

	@Transactional
	public List<Training> getMentorsList(String traineeName) {
		Long id = traineeRepository.findByUserID(traineeName).getId();
		return trainingRepository.getMentorsList(id);
	}

}
