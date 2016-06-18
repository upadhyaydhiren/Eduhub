package com.eduhub.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.dao.GenericDao;
import com.eduhub.dao.SharedContentDao;
import com.eduhub.model.ShareContent;

@Service
@Transactional
public class ShareContentServiceImpl extends
		GenericServiceImpl<Long, ShareContent> implements ShareContentService {

	private SharedContentDao sharedContentDao;

	public ShareContentServiceImpl() {

	}

	@Autowired
	public ShareContentServiceImpl(
			@Qualifier("sharedContentDaoImpl") GenericDao<Long, ShareContent> genericDao) {
		super(genericDao);
		this.sharedContentDao = (SharedContentDao) genericDao;
	}

	@Override
	public List<ShareContent> getAllTopicsByCollegesById(
			Map<String, Object> data) {
		return sharedContentDao.getAllTopicsByCollegesById(data);
	}
	@Override
	public List<User> getAllUsersByTopicId(Long topicId){
		return sharedContentDao.getAllUsersByTopicId(topocId);
	}
}
