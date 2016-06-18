package com.eduhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.dao.GenericDao;
import com.eduhub.model.College;

@Service
@Transactional
public class CollegeServiceImpl extends GenericServiceImpl<Long, College>
		implements CollegeService {

	public CollegeServiceImpl() {

	}

	@Autowired
	public CollegeServiceImpl(
			@Qualifier("collegeDaoImpl") GenericDao<Long, College> genericDao) {
		super(genericDao);
	}
}
