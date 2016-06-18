package com.eduhub.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.model.User;


@Repository
@Transactional
public class UserDaoImpl extends GenericDaoImpl<Long, User> implements UserDao {

	

}
