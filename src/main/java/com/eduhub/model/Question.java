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

@Entity(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String body;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@ManyToMany
	@JoinTable(name = "question_topics", joinColumns = { @JoinColumn(name = "question_id") }, inverseJoinColumns = { @JoinColumn(name = "topics_id") })
	private List<Topics> topics;

	@Column
	private Boolean isClosed;

	@Column(name = "vote")
	private Long vote;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userId;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getBody() {
		return body;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setIsClosed(Boolean isClosed) {
		this.isClosed = isClosed;
	}

	public void setTopics(List<Topics> topics) {
		this.topics = topics;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public void setVote(Long vote) {
		this.vote = vote;
	}

	public Boolean getIsClosed() {
		return isClosed;
	}

	public List<Topics> getTopics() {
		return topics;
	}

	public Long getVote() {
		return vote;
	}

	public User getUserId() {
		return userId;
	}

}
