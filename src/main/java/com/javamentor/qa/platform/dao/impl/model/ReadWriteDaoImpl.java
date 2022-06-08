package com.javamentor.qa.platform.dao.impl.model;

import com.javamentor.qa.platform.models.entity.user.User;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

public abstract class ReadWriteDaoImpl<E, K> extends ReadOnlyDaoImpl<E, K> {

    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
    private int batchSize;

    @PersistenceContext
    private EntityManager entityManager;

    private final Class<E> clazz;

    @SuppressWarnings("unchecked")
    public ReadWriteDaoImpl() {
        this.clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }


    public void persist(E e) {
        entityManager.persist(e);
    }

    public void update(E e) {
        entityManager.merge(e);
    }

    public void delete(E e) {
        entityManager.remove(e);
    }

    public void persistAll(E... entities) {
        int i = 0;
        for (E e : entities) {
            entityManager.persist(e);
            i++;
            if (i % batchSize == 0 && i > 0) {
                entityManager.flush();
                entityManager.clear();
                i = 0;
            }
        }
        if (i > 0) {
            entityManager.flush();
            entityManager.clear();
        }
    }
    public void persistAll(Collection<E> entities) {
        int i = 0;
        for (E e : entities) {
            entityManager.persist(e);
            i++;
            if (i % batchSize == 0 && i > 0) {
                entityManager.flush();
                entityManager.clear();
                i = 0;
            }
        }
        if (i > 0) {
            entityManager.flush();
            entityManager.clear();
        }
    }

    public void deleteAll(Collection<E> entities) {
        int i = 0;
        for (E e : entities) {
            entityManager.remove(entityManager.contains(e) ? e : entityManager.merge(e));
            i++;
            if (i % batchSize == 0 && i > 0) {
                entityManager.flush();
                entityManager.clear();
                i = 0;
            }
        }
        if (i > 0) {
            entityManager.flush();
            entityManager.clear();
        }
    }

    public void updateAll(Iterable<? extends E> entities) {
        int i = 0;
        for (E e : entities) {
            entityManager.merge(e);
            i++;
            if (i % batchSize == 0 && i > 0) {
                entityManager.flush();
                entityManager.clear();
                i = 0;
            }
        }
        if (i > 0) {
            entityManager.flush();
            entityManager.clear();
        }
    }

    public void deleteById(K id) {
        entityManager.createQuery("delete " + clazz.getName() + " where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public void resetPassword(User user) {
        entityManager.createQuery("update User u set u.password = :password where u.id = :id")
                .setParameter("password", user.getPassword())
                .setParameter("id", user.getId())
                .executeUpdate();
    }

    public void updateUserPublicInfo(User user) {
        entityManager.createQuery("update User u set " +
                        "u.email = :email," +
                        "u.password = :password," +
                        "u.city = :city," +
                        "u.linkSite = :linkSite," +
                        "u.linkGitHub = :linkGitHub," +
                        "u.linkVk = :linkVk," +
                        "u.about = :about," +
                        "u.imageLink = :imageLink," +
                        "u.nickname = :nickname," +
                        "u.role = :role " +
                        " where u.id = :id")
                .setParameter("email", user.getEmail())
                .setParameter("password", user.getPassword())
                .setParameter("city", user.getCity())
                .setParameter("linkSite", user.getLinkSite())
                .setParameter("linkGitHub", user.getLinkGitHub())
                .setParameter("linkVk", user.getLinkVk())
                .setParameter("about", user.getAbout())
                .setParameter("imageLink", user.getImageLink())
                .setParameter("nickname", user.getNickname())
                .setParameter("role", user.getRole())
                .setParameter("id", user.getId())
                .executeUpdate();
    }
}
