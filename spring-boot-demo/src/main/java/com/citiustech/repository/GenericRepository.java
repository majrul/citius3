package com.citiustech.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class GenericRepository {

	@PersistenceContext
	protected EntityManager entityManager;
	
	public Object save(Object obj) {
			return entityManager.merge(obj); 
	}

	public <E> E findById(Class<E> clazz, Object pk) {
			E e = entityManager.find(clazz, pk);
			return e;
	}

}
