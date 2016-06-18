package com.eduhub.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.model.Answer;

@Repository
@Transactional
public class AnswerDaoImpl extends GenericDaoImpl<Long, Answer> implements
		AnswerDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Answer> getAllAnswerById(Long questionId) {

		Criteria criteria = getSession().createCriteria(Answer.class);
		criteria.add(Restrictions.eq("question.id", questionId));
		return criteria.list();
	}

}
