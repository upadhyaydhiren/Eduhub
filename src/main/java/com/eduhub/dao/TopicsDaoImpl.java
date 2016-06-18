package com.eduhub.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.model.Topics;

@Repository
@Transactional
public class TopicsDaoImpl extends GenericDaoImpl<Long, Topics> implements
		TopicsDao {

}
