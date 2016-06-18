package com.eduhub.service;

import java.util.List;
import java.util.Map;

import com.eduhub.model.ShareContent;

public interface ShareContentService extends GenericService<Long, ShareContent> {

	List<ShareContent> getAllTopicsByCollegesById(Map<String, Object> data);
}
