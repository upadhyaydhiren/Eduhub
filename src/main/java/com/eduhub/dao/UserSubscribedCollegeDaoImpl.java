package com.eduhub.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.model.UserSubscribedCollege;

@Repository
@Transactional
public class UserSubscribedCollegeDaoImpl extends
		GenericDaoImpl<Long, UserSubscribedCollege> implements
		UserSubscribedCollegeDao {

}
