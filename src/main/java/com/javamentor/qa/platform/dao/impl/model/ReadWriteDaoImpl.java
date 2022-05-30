package com.javamentor.qa.platform.dao.impl.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

public abstract class ReadWriteDaoImpl<E, K> extends ReadOnlyDaoImpl<E, K> {

    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
    private int batchSize;

    @PersistenceContext
    private EntityManager entityManager;

    private Class<E> clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
            .getActualTypeArguments()[0];

}
