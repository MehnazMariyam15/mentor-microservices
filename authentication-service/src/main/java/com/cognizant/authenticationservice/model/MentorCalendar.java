package com.cognizant.authenticationservice.model;

import java.sql.Date;
import java.sql.Time;

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
@Table(name="mentor_calendar")
public class MentorCalendar {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mc_id")
	private Long id;

	@Column(name = "mc_start_time")
	private Time startTime;
	
	@Column(name = "mc_end_time")
	private Time endTime;
	
	@Column(name = "mc_start_date")
	private Date startDate;
	
	@Column(name = "mc_end_date")
	private Date endDate;
	
	@ManyToOne
	@JoinColumn(name = "mc_me_id")
	@JsonIgnore
	private Mentor mentorId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	

	public Mentor getMentorId() {
		return mentorId;
	}

	public void setMentorId(Mentor mentorId) {
		this.mentorId = mentorId;
	}

	@Override
	public String toString() {
		return "MentorCalendar [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
	
	
}
