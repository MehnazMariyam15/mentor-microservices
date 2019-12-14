package com.cognizant.searchservice.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mentor")
public class Mentor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "me_id")
	private Long id;

	@Column(name = "me_firstname")
	private String firstName;

	@Column(name = "me_lastname")
	private String lastName;

	@Column(name = "me_contact_no")
	private String contactNo;

	@Column(name = "me_email")
	private String email;

	@Column(name = "me_userid")
	private String userID;

	@Column(name = "me_linkedin_Url")
	private String linkedInUrl;

	@Column(name = "me_years_of_experience")
	private Float yearsOfExperience;

	@Column(name = "me_password")
	private String password;

	@Column(name = "me_confirm_password")
	private String confirmPassword;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "mentorId")
	@JsonIgnore
	private Set<MentorSkills> mentorSkillsList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getLinkedInUrl() {
		return linkedInUrl;
	}

	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}

	public Float getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(Float yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Set<MentorSkills> getMentorSkillsList() {
		return mentorSkillsList;
	}

	public void setMentorSkillList(Set<MentorSkills> mentorSkillsList) {
		this.mentorSkillsList = mentorSkillsList;
	}

	@Override
	public String toString() {
		return "Mentor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNo=" + contactNo
				+ ", email=" + email + ", userID=" + userID + ", linkedInUrl=" + linkedInUrl + ", yearsOfExperience="
				+ yearsOfExperience + ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}

}
