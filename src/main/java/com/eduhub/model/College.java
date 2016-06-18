package com.eduhub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "college")
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "college_name", nullable = false)
	private String collegeName;

	@Column(name = "college_url")
	private String collegeUrl;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeUrl(String collegeUrl) {
		this.collegeUrl = collegeUrl;
	}

	public String getCollegeUrl() {
		return collegeUrl;
	}
}
