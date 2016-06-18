package com.eduhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.dao.GenericDao;
import com.eduhub.model.Topics;

@Service
@Transactional
public class TopicsServiceImpl extends GenericServiceImpl<Long, Topics>
		implements TopicsService {

	public TopicsServiceImpl() {

	}

	@Autowired
	public TopicsServiceImpl(
			@Qualifier("topicsDaoImpl") GenericDao<Long, Topics> genericDao) {
		super(genericDao);
	}
}
