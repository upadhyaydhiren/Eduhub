package com.eduhub.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ctaegory_name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "category")
	private List<Topics> topics;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setTopics(List<Topics> topics) {
		this.topics = topics;
	}

	public List<Topics> getTopics() {
		return topics;
	}
}
