package com.eduhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.dao.GenericDao;
import com.eduhub.model.Group;

@Service
@Transactional
public class GroupServiceImpl extends GenericServiceImpl<Long, Group> implements
		GroupService {

	public GroupServiceImpl() {

	}

	@Autowired
	public GroupServiceImpl(
			@Qualifier("groupDaoImpl") GenericDao<Long, Group> genericDao) {
		super(genericDao);
	}

}
