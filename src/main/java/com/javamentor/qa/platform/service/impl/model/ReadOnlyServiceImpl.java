package com.javamentor.qa.platform.service.impl.model;

import com.javamentor.qa.platform.dao.abstracts.model.ReadOnlyDao;
import com.javamentor.qa.platform.service.abstracts.model.ReadOnlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public abstract class ReadOnlyServiceImpl<E, K> implements ReadOnlyService<E, K> {

    private final ReadOnlyDao readOnlyDao;

    @Autowired
    public ReadOnlyServiceImpl(ReadOnlyDao readOnlyDao) {
        this.readOnlyDao = readOnlyDao;
    }

    @Override
    public List<E> getAll() {
        return readOnlyDao.getAll();
    }

    @Override
    public boolean existsById(K id) {
        return readOnlyDao.existsById(id);
    }

    @Override
    public Optional<E> getById(K id) {
        return readOnlyDao.getById(id);
    }

    @Override
    public List<E> getAllByIds(Iterable<K> ids) {
        return readOnlyDao.getAllByIds(ids);
    }

    @Override
    public boolean existsByAllIds(Collection<K> ids) {
        return readOnlyDao.existsByAllIds(ids);
    }
}
