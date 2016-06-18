package com.eduhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.dao.GenericDao;
import com.eduhub.model.Question;

@Service
@Transactional
public class QuestionServiceImpl extends GenericServiceImpl<Long, Question>
		implements QuestionService {

	public QuestionServiceImpl() {

	}

	@Autowired
	public QuestionServiceImpl(
			@Qualifier("questionDaoImpl") GenericDao<Long, Question> genericDao) {
		super(genericDao);
	}

}
