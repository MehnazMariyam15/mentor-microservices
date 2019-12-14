package com.cognizant.authenticationservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "trainee")
public class Trainee {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tr_id")
    private Long id;

    @Column(name = "tr_firstname")
    private String firstName;

    @Column(name = "tr_lastname")
    private String lastName;

    @Column(name = "tr_contact_no")
    private String contactNo;

    @Column(name = "tr_email")
    private String email;

    @Column(name = "tr_userid")
    private String userID;

    @Column(name = "tr_password")
    private String password;

    @Column(name = "tr_confirm_password")
    private String confirmPassword;


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

	@Override
	public String toString() {
		return "Trainee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNo=" + contactNo
				+ ", email=" + email + ", userID=" + userID + ", password=" + password + ", confirmPassword="
				+ confirmPassword + "]";
	}
	
	
}
