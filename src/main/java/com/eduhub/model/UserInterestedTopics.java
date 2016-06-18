package com.eduhub.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "user_interested_topics")
public class UserInterestedTopics extends UserInterestArea {

	@ManyToOne
	@JoinColumn(name = "topics_id")
	private Topics topics;

	public void setTopics(Topics topics) {
		this.topics = topics;
	}

	public Topics getTopics() {
		return topics;
	}
}
