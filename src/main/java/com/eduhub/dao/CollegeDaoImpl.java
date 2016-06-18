package com.eduhub.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.model.College;

@Repository
@Transactional
public class CollegeDaoImpl extends GenericDaoImpl<Long, College> implements
		CollegeDao {

}
