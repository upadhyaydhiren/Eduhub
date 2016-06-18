package com.eduhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.dao.GenericDao;
import com.eduhub.model.UserInterestedTopics;

@Service
@Transactional
public class UserInterestedTopicsServiceImpl extends
		GenericServiceImpl<Long, UserInterestedTopics> implements
		UserInterestedTopicsService {

	@Autowired
	public UserInterestedTopicsServiceImpl(@Qualifier("userInterestedTopicsDaoImpl")
			GenericDao<Long, UserInterestedTopics> genericDao) {
		super(genericDao);
	}

	public UserInterestedTopicsServiceImpl() {
	}

}
