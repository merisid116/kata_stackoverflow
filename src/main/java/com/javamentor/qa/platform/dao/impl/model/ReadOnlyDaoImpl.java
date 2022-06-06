package com.javamentor.qa.platform.dao.impl.model;

import com.javamentor.qa.platform.dao.abstracts.model.ReadOnlyDao;
import com.javamentor.qa.platform.dao.util.SingleResultUtil;
import com.javamentor.qa.platform.models.entity.user.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.*;


@Repository
public abstract class ReadOnlyDaoImpl<E, K> implements ReadOnlyDao<E, K> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<E> clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
            .getActualTypeArguments()[0];

    @Override
    public List<E> getAll() {
        return entityManager.createQuery("FROM " + clazz.getName()).getResultList();
    }

    @Override
    public Optional<User> getByEmail(String email) {
        Query query = entityManager.createQuery("SELECT u FROM User u join fetch u.roles where u.email = :email", User.class).setParameter("email", email);
        return SingleResultUtil.getSingleResultOrNull(query);
    }

    @Override
    public Optional<E> getById(K id) {
        Query query = entityManager.createQuery("SELECT u FROM" + clazz.getName() + "u WHERE u.id = :id", clazz).setParameter("id", id);
        return SingleResultUtil.getSingleResultOrNull(query);
    }

    @Override
    public List<E> getAllByIds(Iterable<K> ids) {
        if (ids != null && !ids.iterator().hasNext()) {
            Query query = entityManager.createQuery("SELECT u FROM" + clazz.getName() + "u WHERE u.id IN :ids", clazz).setParameter("ids", ids);
            return query.getResultList();
        } else {
            return null;
        }
    }

    @Override
    public boolean existsById(K id) {
        return entityManager.createQuery("SELECT u FROM " + clazz.getName() + "u WHERE u.id IN :id", clazz).setParameter("id", id).getResultList().size() > 0;
    }

    @Override
    public boolean existsByAllIds(Collection<K> ids) {
        if (ids != null && !ids.iterator().hasNext()) {
            Query query = entityManager.createQuery("SELECT u FROM " + clazz.getName() + "u WHERE u.id IN :ids", clazz).setParameter("ids", ids);
            List<E> list = query.getResultList();
            if (list.size() == ids.size()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}