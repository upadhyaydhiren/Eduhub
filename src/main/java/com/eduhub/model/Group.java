package com.eduhub.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "user_group")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "group_name", nullable = false)
	private String groupName;

	@ManyToOne
	@JoinColumn(name = "group_admin_id", nullable = false)
	private User groupAdmin;

	@Column(name = "createdDate")
	private Long createdDate;

	@ManyToMany
	@JoinTable(name = "group_users", joinColumns = { @JoinColumn(name = "group_id") }, inverseJoinColumns = { @JoinColumn(name = "user_id") })
	private List<User> groupUsers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public User getGroupAdmin() {
		return groupAdmin;
	}

	public void setGroupAdmin(User groupAdmin) {
		this.groupAdmin = groupAdmin;
	}

	public Long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}

	public List<User> getGroupUsers() {
		return groupUsers;
	}

	public void setGroupUsers(List<User> groupUsers) {
		this.groupUsers = groupUsers;
	}

}
