package com.eduhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.dao.GenericDao;
import com.eduhub.model.UserSubscribedCollege;

@Service
@Transactional
public class UserSubscribedCollegeServiceImpl extends
		GenericServiceImpl<Long, UserSubscribedCollege> implements
		UserSubscribedCollegeService {

	@Autowired
	public UserSubscribedCollegeServiceImpl(
			@Qualifier("userSubscribedCollegeDaoImpl") GenericDao<Long, UserSubscribedCollege> genericDao) {
		super(genericDao);

	}

	public UserSubscribedCollegeServiceImpl() {

	}

}
