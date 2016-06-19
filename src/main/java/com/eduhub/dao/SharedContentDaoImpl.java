package com.eduhub.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.model.ShareContent;
import com.eduhub.model.User;

@Repository
@Transactional
public class SharedContentDaoImpl extends GenericDaoImpl<Long, ShareContent>
		implements SharedContentDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ShareContent> getAllTopicsByCollegesById(
			Map<String, Object> data) {

		Criteria criteria = getSession().createCriteria(User.class);

		if (data.get("NAME") != null) {
			criteria.add(Restrictions.like("colleges.name",
					"%" + String.valueOf(data.get("NAME")) + "%"));
		}

		else if (data.get("ID") != null) {
			criteria.add(Restrictions.eq("colleges.id", data.get("ID")));
		}

		List<User> users = criteria.list();

		if (!users.isEmpty()) {
			List<Long> userId = new ArrayList<Long>();
			for (User user : users) {
				userId.add(user.getId());
			}
			Criteria sharedCriteria = getSession().createCriteria(
					ShareContent.class);
			if (data.get("CATEGORYID") != null
					&& data.get("CATEGORYTYPE") != null) {
				if (data.get("CATEGORYTYPE").toString().equals("CATEGORY")) {
					sharedCriteria.createAlias("sharedContentTopics.category",
							"category");
					sharedCriteria.add(Restrictions.eq("category.id",
							(Long) data.get("CATEGORYID")));
				}

				else {
					sharedCriteria.add(Restrictions.eq(
							"sharedContentTopics.id",
							(Long) data.get("CATEGORYID")));
				}

			}

			sharedCriteria.add(Restrictions.in("user.id", userId));
			return sharedCriteria.list();
		}

		return null;
	}

	public List<User> getAllUsersByTopicId(Long topicId) {
		List<User> userList = new ArrayList<User>();
		Criteria criteria = getSession().createCriteria(ShareContent.class);
		@SuppressWarnings("unchecked")
		List<ShareContent> sharedContentListByTopic = criteria.add(
				Restrictions.eq("sharedContentTopics.id", topicId)).list();
		if (null != sharedContentListByTopic) {
			for (int i = 0; i < sharedContentListByTopic.size(); i++) {
				userList.add(sharedContentListByTopic.get(i).getUser());
			}
		}
		return userList;
	}
}
