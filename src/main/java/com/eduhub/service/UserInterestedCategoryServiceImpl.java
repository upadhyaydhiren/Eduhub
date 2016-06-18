package com.eduhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.dao.GenericDao;
import com.eduhub.model.UserInterestedCategory;

@Service
@Transactional
public class UserInterestedCategoryServiceImpl extends
		GenericServiceImpl<Long, UserInterestedCategory> implements
		UserInterestedCategoryService {

	@Autowired
	public UserInterestedCategoryServiceImpl(
			@Qualifier("userInterestedCategoryDaoImpl") GenericDao<Long, UserInterestedCategory> genericDao) {
		super(genericDao);
	}

	public UserInterestedCategoryServiceImpl() {

	}

}
