package com.javamentor.qa.platform.dao.impl.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

public abstract class ReadOnlyDaoImpl<E, K> {
    @PersistenceContext
    private EntityManager entityManager;

    private Class<E> clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
            .getActualTypeArguments()[0];

}
