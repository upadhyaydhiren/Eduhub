package com.eduhub.service;

import java.util.List;
import java.util.Map;

import com.eduhub.model.ShareContent;
import com.eduhub.model.User;

public interface ShareContentService extends GenericService<Long, ShareContent> {

	List<ShareContent> getAllTopicsByCollegesById(Map<String, Object> data);

	public List<User> getAllUsersByTopicId(Long topicId);
}
