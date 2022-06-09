package com.javamentor.qa.platform.dao.impl.model;

import com.javamentor.qa.platform.dao.abstracts.model.ReadOnlyDao;
import com.javamentor.qa.platform.dao.util.SingleResultUtil;
import com.javamentor.qa.platform.models.entity.user.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class ReadOnlyDaoImpl<E, K> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<E> clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
            .getActualTypeArguments()[0];

    public List<E> getAll() {
        return entityManager.createQuery("FROM " + clazz.getName()).getResultList();
    }

    public Optional<User> getByEmail(String email) {
        Query query = entityManager.createQuery("SELECT u FROM User u join fetch u.roles where u.email = :email", User.class).setParameter("email", email);
        return SingleResultUtil.getSingleResultOrNull(query);
    }

    public Optional<E> getById(K id) {
        Query query = entityManager.createQuery("SELECT u FROM" + clazz.getName() + "u WHERE u.id = :id", clazz).setParameter("id", id);
        return SingleResultUtil.getSingleResultOrNull(query);
    }

    public List<E> getAllByIds(Iterable<K> ids) {
        if (ids != null && ids.iterator().hasNext()) {
            return entityManager.createQuery("from " + clazz.getName() + " e WHERE e.id IN :ids")
                    .setParameter("ids", ids).getResultList();
        } else {
            return new ArrayList<>();
        }
    }

    public boolean existsById(K id) {
        return entityManager.createQuery("SELECT u FROM " + clazz.getName() + " u WHERE u.id IN :id", clazz).setParameter("id", id).getResultList().size() > 0;
    }

    public boolean existsByAllIds(Collection<K> ids) {
        if (ids != null && ids.size() > 0) {
            Long count = (Long) entityManager.createQuery("select count(*) from " + clazz.getName() + " e WHERE e.id IN :ids")
                    .setParameter("ids", ids).getSingleResult();
            return ids.size() == count;
        }
        return false;
    }
}