package com.eduhub.dao;

import java.util.List;
import java.util.Map;

import com.eduhub.model.ShareContent;
import com.eduhub.model.User;

public interface SharedContentDao extends GenericDao<Long, ShareContent> {

	List<ShareContent> getAllTopicsByCollegesById(Map<String, Object> data);

	List<User> getAllUsersByTopicId(Long topicId);
}
