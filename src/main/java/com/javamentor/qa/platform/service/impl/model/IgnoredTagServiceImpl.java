package com.javamentor.qa.platform.service.impl.model;

import com.javamentor.qa.platform.dao.abstracts.model.IgnoredTagDao;
import com.javamentor.qa.platform.exception.ConstrainException;
import com.javamentor.qa.platform.models.entity.question.IgnoredTag;
import com.javamentor.qa.platform.models.entity.question.Tag;
import com.javamentor.qa.platform.models.entity.user.User;
import com.javamentor.qa.platform.service.abstracts.model.IgnoredTagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;
@Transactional
@Service
public class IgnoredTagServiceImpl extends ReadWriteServiceImpl<IgnoredTag, Long> implements IgnoredTagService {
    @PersistenceContext
    private EntityManager entityManager;
    private final IgnoredTagDao ignoredTagDao;
    private static final String ENTITIES_MUST_NOT_BE_NULL = "Entities cannot be null and empty";

    public IgnoredTagServiceImpl(IgnoredTagDao ignoredTagDao) {
        super(ignoredTagDao);
        this.ignoredTagDao = ignoredTagDao;
    }

    @Override
    public Optional<IgnoredTag> getByUserAndTag(User user, Tag tag) {
        return ignoredTagDao.getByUserAndTag(user, tag);
    }

    @Override
    public IgnoredTag add(Long tagId, User user) {
        IgnoredTag tag = new IgnoredTag(tagId,user);
        if(tagId == null){
            throw new ConstrainException(ENTITIES_MUST_NOT_BE_NULL);
        }else{
           entityManager.persist(tag);
        }
        return tag;
    }
}
