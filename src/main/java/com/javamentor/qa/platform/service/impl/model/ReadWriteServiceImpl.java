package com.javamentor.qa.platform.service.impl.model;

import com.javamentor.qa.platform.dao.abstracts.model.ReadOnlyDao;
import com.javamentor.qa.platform.dao.abstracts.model.ReadWriteDao;
import com.javamentor.qa.platform.models.entity.user.User;
import com.javamentor.qa.platform.service.abstracts.model.ReadWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public abstract class ReadWriteServiceImpl<E, K> extends ReadOnlyServiceImpl<E, K> implements ReadWriteService<E, K> {

    private final ReadWriteDao readWriteDao;

    @Autowired
    public ReadWriteServiceImpl(ReadOnlyDao dao, ReadWriteDao readWriteDao) {
        super(dao);
        this.readWriteDao = readWriteDao;
    }

    @Override
    public void persist(E e) {
        readWriteDao.persist(e);
    }

    @Override
    public void update(E e) {
        readWriteDao.update(e);
    }

    @Override
    public void delete(E e) {
        readWriteDao.delete(e);
    }

    @Override
    public void persistAll(E... entities) {
        readWriteDao.persistAll(entities);
    }

    @Override
    public void persistAll(Collection<E> entities) {
        readWriteDao.persistAll(entities);
    }

    @Override
    public void deleteAll(Collection<E> entities) {
        readWriteDao.deleteAll(entities);
    }

    @Override
    public void updateAll(Iterable<? extends E> entities) {
        readWriteDao.updateAll(entities);
    }

    @Override
    public void deleteById(K id) {
        readWriteDao.deleteById(id);
    }

    @Override
    public void resetPassword(User user) {
        readWriteDao.resetPassword(user);
    }

    @Override
    public void updateUserPublicInfo(User user) {
        readWriteDao.updateUserPublicInfo(user);
    }
}
