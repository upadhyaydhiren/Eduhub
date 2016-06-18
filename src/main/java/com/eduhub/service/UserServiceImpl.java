package com.eduhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.dao.GenericDao;
import com.eduhub.model.User;

@Service
@Transactional
public class UserServiceImpl extends GenericServiceImpl<Long, User> implements
		UserService {

	public UserServiceImpl() {

	}

	@Autowired
	public UserServiceImpl(
			@Qualifier("userDaoImpl") GenericDao<Long, User> genericDao) {
		super(genericDao);
	}

}
