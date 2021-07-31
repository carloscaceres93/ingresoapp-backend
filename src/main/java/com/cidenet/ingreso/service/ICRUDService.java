package com.cidenet.ingreso.service;

import java.util.List;

public interface ICRUDService<T, ID> {

	T save(T t) throws Exception;

	T modify(T t) throws Exception;

	List<T> findAll() throws Exception;

	T findById(ID id) throws Exception;

	void delete(ID id) throws Exception;
}
