package com.eduhub.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

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
			category.setId(Long.valueOf(1));
			category.setName("Java");
			Topics topics = new Topics();
			topics.setId(Long.valueOf(1));
			topics.setName("spring");
			topics.setCategory(category);
			List<Topics> listTopics = new ArrayList<Topics>();
			listTopics.add(topics);
			category.setTopics(listTopics);
			Category category1 = new Category();
			category1.setId(Long.valueOf(2));
			category1.setName("DB");
			Topics topics1 = new Topics();
			topics1.setId(Long.valueOf(1));
			topics1.setName("MYSQL");
			topics1.setCategory(category1);
			List<Topics> listTopics1 = new ArrayList<Topics>();
			listTopics1.add(topics1);
			category1.setTopics(listTopics1);
			categories.add(category);
			categories.add(category1);
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
			return new ResponseEntity<List<User>>(
					shareContentService.getAllUsersByTopicId(topicsid),
					HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Server error in getcontributers", e);
			return new ResponseEntity<List<User>>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "searchquestion", method = RequestMethod.POST)
	public ResponseEntity<String> getSearchResult(
			@RequestParam(name = "q") String q) {
		try {

			HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
					HttpClientBuilder.create().build());
			RestTemplate restTemplate = new RestTemplate(
					clientHttpRequestFactory);
			UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
					.fromHttpUrl(
							"https://api.stackexchange.com/2.2/search/advanced")
					.queryParam("key", "7vefr96v0CVdajRSCXy3pA((")
					.queryParam("site", "math").queryParam("order", "desc")
					.queryParam("sort", "activity").queryParam("q", q);
			ResponseEntity<String> responseEntity = restTemplate.exchange(
					uriComponentsBuilder.build().encode().toUri(),
					HttpMethod.GET, null, String.class);
			return new ResponseEntity<String>(responseEntity.getBody(),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "sharedcontent", method = RequestMethod.POST)
	public ResponseEntity<Boolean> upload(
			@RequestParam(value = "file", required = false) MultipartFile multipartFile,
			@RequestParam(value = "content", required = false) String content) {
		try {
			ShareContent shareContent = new ShareContent();

			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
