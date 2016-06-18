package com.eduhub.service;

import java.util.List;

import com.eduhub.model.Answer;

public interface AnswerService extends GenericService<Long, Answer> {

	List<Answer> getAllAnswerById(Long questionId);
}
