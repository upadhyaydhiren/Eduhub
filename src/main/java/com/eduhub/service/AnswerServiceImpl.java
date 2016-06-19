package com.eduhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.dao.AnswerDao;
import com.eduhub.dao.GenericDao;
import com.eduhub.model.Answer;

@Service
@Transactional
public class AnswerServiceImpl extends GenericServiceImpl<Long, Answer>
		implements AnswerService {

	private AnswerDao answerDao;

	public AnswerServiceImpl() {

	}

	@Autowired
	public AnswerServiceImpl(
			@Qualifier("answerDaoImpl") GenericDao<Long, Answer> genericDao) {
		super(genericDao);
		this.answerDao = (AnswerDao) genericDao;
	}

	@Override
	public List<Answer> getAllAnswerById(Long questionId) {
		return answerDao.getAllAnswerById(questionId);
	}
}
