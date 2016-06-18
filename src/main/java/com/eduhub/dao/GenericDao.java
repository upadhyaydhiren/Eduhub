package com.eduhub.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<PK, T> {

	public Serializable save(T entity) throws Exception;

	public void update(T entity) throws Exception;

	public void delete(T entity) throws Exception;

	public T getById(PK key) throws Exception;

	public List<T> getAll() throws Exception;
}
