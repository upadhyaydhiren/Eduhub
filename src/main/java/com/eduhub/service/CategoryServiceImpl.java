package com.eduhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.dao.GenericDao;
import com.eduhub.model.Category;

@Transactional
@Repository
public class CategoryServiceImpl extends GenericServiceImpl<Long, Category>
		implements CategoryService {

	public CategoryServiceImpl() {

	}

	@Autowired
	public CategoryServiceImpl(
			@Qualifier("categoryDaoImpl") GenericDao<Long, Category> genericDao) {
		super(genericDao);
		System.out.println("" + genericDao == null + "----->");
	}
}
