package com.eduhub.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eduhub.model.ShareContent;
import com.eduhub.service.QuestionService;

@Controller
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = "question", method = RequestMethod.GET)
	public ResponseEntity<ShareContent> getQuestion() {
		try {

			logger.info("error");
			return new ResponseEntity<ShareContent>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error in question", e);
			return new ResponseEntity<ShareContent>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
