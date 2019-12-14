package com.cognizant.searchservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mentor_skill")
public class MentorSkills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ms_id")
	Long id;

	@Column(name = "ms_self_rating")
	Long rating;

	@Column(name = "ms_exp")
	Long experience;

	@Column(name = "ms_trainings_delivered")
	String trainings;

	@Column(name = "ms_facilities")
	String facilities;

	@ManyToOne
	@JoinColumn(name = "ms_me_id")
	Mentor mentorId;

	@ManyToOne
	@JoinColumn(name = "ms_sk_id")
	Technology skillId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public Long getExperience() {
		return experience;
	}

	public void setExperience(Long experience) {
		this.experience = experience;
	}

	public String getTrainings() {
		return trainings;
	}

	public void setTrainings(String trainings) {
		this.trainings = trainings;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public Mentor getMentorId() {
		return mentorId;
	}

	public void setMentorId(Mentor mentorId) {
		this.mentorId = mentorId;
	}

	public Technology getSkillId() {
		return skillId;
	}

	public void setSkillId(Technology skillId) {
		this.skillId = skillId;
	}

	@Override
	public String toString() {
		return "MentorSkills [id=" + id + ", rating=" + rating + ", experience=" + experience + ", trainings="
				+ trainings + ", facilities=" + facilities + "]";
	}
}
