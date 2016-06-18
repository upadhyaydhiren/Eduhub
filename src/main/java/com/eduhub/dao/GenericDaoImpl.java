package com.eduhub.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public abstract class GenericDaoImpl<PK extends Serializable, T> implements
		GenericDao<PK, T> {

	@Autowired
	private SessionFactory sessionFactory;

	protected Class<? extends T> persistentClass;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		this.persistentClass = (Class<? extends T>) ((ParameterizedType) this
				.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(PK Id) throws Exception {
		return (T) getSession().get(persistentClass, Id);
	}

	@Override
	public Serializable save(T entity) throws Exception {
		Serializable id = getSession().save(entity);
		return id;
	}

	@Override
	public void update(T entity) throws Exception {
		getSession().update(entity);
	}

	@Override
	public void delete(T entity) throws Exception {
		getSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() throws Exception {
		return getSession().createCriteria(persistentClass).list();
	}
}