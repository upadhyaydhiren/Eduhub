package com.eduhub.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eduhub.model.Category;
import com.eduhub.model.College;
import com.eduhub.model.ShareContent;
import com.eduhub.model.Topics;
import com.eduhub.model.User;
import com.eduhub.service.CategoryService;
import com.eduhub.service.CollegeService;
import com.eduhub.service.ShareContentService;

@Controller
public class IndexController {

	private final Logger logger = LoggerFactory
			.getLogger(IndexController.class);

	@Autowired
	private CollegeService collegeService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ShareContentService shareContentService;

	@RequestMapping(value = "category", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> getTopics() {
		try {

			logger.info("category load");
			List<Category> categories = new ArrayList<Category>();
			Category category = new Category();
			category.setName("Java");
			Topics topics = new Topics();
			topics.setName("spring");
			topics.setCategory(category);
			categories.add(category);
			return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("server error in category", e);
			return new ResponseEntity<List<Category>>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "colleges", method = RequestMethod.GET)
	public ResponseEntity<List<College>> getAllColleges() {
		try {

			logger.info("colleges load");
			return new ResponseEntity<List<College>>(collegeService.getAll(),
					HttpStatus.OK);
		} catch (Exception e) {
			logger.error("server error in colleges", e);
			return new ResponseEntity<List<College>>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "contributers", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllContributer() {
		try {

			List<User> users = new ArrayList<User>();

			for (ShareContent shareContent : shareContentService.getAll()) {
				users.add(shareContent.getUser());
			}
			logger.info("contributers load");
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("server error in contributers", e);
			return new ResponseEntity<List<User>>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "getontributerbytopicsid/{topicsid}", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getCntributerById(
			@PathVariable("topicsid") Long topicsid) {
		try {

		} catch (Exception e) {
			logger.error("Server error in getcontributers", e);
			return new ResponseEntity<List<User>>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
