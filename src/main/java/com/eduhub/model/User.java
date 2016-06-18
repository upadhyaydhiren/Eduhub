package com.eduhub.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "full_name", nullable = false)
	private String fullName;

	@Column(unique = true, name = "email", nullable = false)
	private String email;

	@Column(name = "mobile")
	private String mobileNo;

	@Column(name = "dob")
	private Long dob;

	@ManyToMany
	@JoinTable(name = "college_user", joinColumns = { @JoinColumn(name = "user_id", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "college_id") })
	private List<College> colleges;

	@Column(name = "user_profession")
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private List<Profession> professions;

	@ManyToMany
	@JoinTable(name = "user_experties", joinColumns = { @JoinColumn(name = "user_id", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "category_id") })
	private List<Topics> areaOfExperties;

	@Column()
	private Integer reputation;

	@Column(name = "")
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setDob(Long dob) {
		this.dob = dob;
	}

	public void setColleges(List<College> colleges) {
		this.colleges = colleges;
	}

	public List<College> getColleges() {
		return colleges;
	}

	public void setProfessions(List<Profession> professions) {
		this.professions = professions;
	}

	public List<Profession> getProfessions() {
		return professions;
	}

	public void setAreaOfExperties(List<Topics> areaOfExperties) {
		this.areaOfExperties = areaOfExperties;
	}

	public List<Topics> getAreaOfExperties() {
		return areaOfExperties;
	}

	public void setReputation(Integer reputation) {
		this.reputation = reputation;
	}

	public Integer getReputation() {
		return reputation;
	}

	public Long getDob() {
		return dob;
	}
}
