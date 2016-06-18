package com.eduhub.model;

import java.io.File;
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
import javax.persistence.Transient;

@Entity(name = "share_content")
public class ShareContent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column
	private String filePath;

	@Transient
	private File contentUrl;

	@ManyToMany
	@JoinTable(name = "share_content_topics", joinColumns = { @JoinColumn(name = "share_content_id", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "topics_id", nullable = false) })
	private List<Topics> sharedContentTopics;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public File getContentUrl() {
		return contentUrl;
	}

	public void setContentUrl(File contentUrl) {
		this.contentUrl = contentUrl;
	}

	public void setSharedContentTopics(List<Topics> sharedContentTopics) {
		this.sharedContentTopics = sharedContentTopics;
	}

	public List<Topics> getSharedContentTopics() {
		return sharedContentTopics;
	}
}
