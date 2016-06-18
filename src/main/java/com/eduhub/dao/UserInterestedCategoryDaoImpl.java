package com.eduhub.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.model.UserInterestedCategory;

@Repository
@Transactional
public class UserInterestedCategoryDaoImpl extends
		GenericDaoImpl<Long, UserInterestedCategory> implements
		UserInterestedCategoryDao {

}
