package com.eduhub.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eduhub.model.Category;

@Repository
@Transactional
public class CategoryDaoImpl extends GenericDaoImpl<Long, Category> implements
		CategoryDao {

}
