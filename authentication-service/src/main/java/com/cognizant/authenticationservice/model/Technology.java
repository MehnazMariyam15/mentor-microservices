package com.cognizant.authenticationservice.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "skills")
public class Technology {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sk_id")
	private Long id;
	
	@Column(name = "sk_name")
	private String skillName;
	
	@Column(name = "sk_duration")
	private String duration;
	
	@Column(name = "sk_toc")
	private String tableOfContents;
	
	@Column(name = "sk_prereq")
	private String prerequisites;
	
	@OneToMany(mappedBy = "skillId")
	@JsonIgnore
	private Set<MentorSkills> mentorSkillsList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getTableOfContents() {
		return tableOfContents;
	}

	public void setTableOfContents(String tableOfContents) {
		this.tableOfContents = tableOfContents;
	}

	public String getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}

	
	public Set<MentorSkills> getMentorSkillsList() {
		return mentorSkillsList;
	}

	public void setMentorSkillsList(Set<MentorSkills> mentorSkillsList) {
		this.mentorSkillsList = mentorSkillsList;
	}

	@Override
	public String toString() {
		return "Skills [id=" + id + ", skillName=" + skillName + ", tableOfContents=" + tableOfContents
				+ ", prerequisites=" + prerequisites + "]";
	}

	
	
	

}
