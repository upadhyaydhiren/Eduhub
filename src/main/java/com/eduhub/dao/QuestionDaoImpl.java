package com.eduhub.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.model.Question;

@Repository
@Transactional
public class QuestionDaoImpl extends GenericDaoImpl<Long, Question> implements
		QuestionDao {
}
