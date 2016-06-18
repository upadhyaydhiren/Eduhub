package com.eduhub.dao;

import java.util.List;

import com.eduhub.model.Answer;

public interface AnswerDao extends GenericDao<Long, Answer> {

	List<Answer> getAllAnswerById(Long questionId);
}
