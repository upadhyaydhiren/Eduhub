package com.eduhub.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.model.Group;

@Repository
@Transactional
public class GroupDaoImpl extends GenericDaoImpl<Long, Group> implements
		GroupDao {

}
