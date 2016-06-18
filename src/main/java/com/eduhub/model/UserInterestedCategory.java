package com.eduhub.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "user_interested_category")
public class UserInterestedCategory extends UserInterestArea {

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}
}
