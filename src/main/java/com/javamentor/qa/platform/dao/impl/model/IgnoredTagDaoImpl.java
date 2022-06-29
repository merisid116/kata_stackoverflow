package com.javamentor.qa.platform.dao.impl.model;

import com.javamentor.qa.platform.dao.abstracts.model.IgnoredTagDao;
import com.javamentor.qa.platform.dao.util.SingleResultUtil;
import com.javamentor.qa.platform.models.entity.question.IgnoredTag;
import com.javamentor.qa.platform.models.entity.question.Tag;
import com.javamentor.qa.platform.models.entity.user.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class IgnoredTagDaoImpl extends ReadWriteDaoImpl<IgnoredTag, Long> implements IgnoredTagDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<IgnoredTag> getByUserAndTag(User user, Tag tag) {
        return SingleResultUtil.getSingleResultOrNull(entityManager.createQuery(
                        "select igt from IgnoredTag igt where igt.user.id =:userId and igt.ignoredTag.id =:tagId", IgnoredTag.class)
                .setParameter("userId", user.getId())
                .setParameter("tagId", tag.getId()));
    }
}
