package com.cognizant.userservice.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "training")
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tg_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "tg_me_id")
	private Mentor mentorId;

	@ManyToOne
	@JoinColumn(name = "tg_tr_id")
	private Trainee traineeId;

	@ManyToOne
	@JoinColumn(name = "tg_te_id")
	private Technology techId;

	@Column(name = "tg_status")
	private String proposalStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Mentor getMentorId() {
		return mentorId;
	}

	public void setMentorId(Mentor mentorId) {
		this.mentorId = mentorId;
	}

	public Trainee getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(Trainee traineeId) {
		this.traineeId = traineeId;
	}

	public Technology getTechId() {
		return techId;
	}

	public void setTechId(Technology techId) {
		this.techId = techId;
	}

	public String getProposalStatus() {
		return proposalStatus;
	}

	public void setProposalStatus(String proposalStatus) {
		this.proposalStatus = proposalStatus;
	}

	@Override
	public String toString() {
		return "MentorTrainee [id=" + id + ", mentorId=" + mentorId + ", traineeId=" + traineeId + ", proposalStatus="
				+ proposalStatus + "]";
	}

}
