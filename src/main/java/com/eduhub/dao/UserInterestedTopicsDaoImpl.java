package com.eduhub.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.model.UserInterestedTopics;

@Repository
@Transactional
public class UserInterestedTopicsDaoImpl extends
		GenericDaoImpl<Long, UserInterestedTopics> implements
		UserInterestedTopicsDao {

}
