package com.javamentor.qa.platform.dao.impl.model;

import com.javamentor.qa.platform.dao.abstracts.model.AnswerDao;
import com.javamentor.qa.platform.dao.util.SingleResultUtil;
import com.javamentor.qa.platform.models.entity.question.answer.Answer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public class AnswerDaoImpl extends ReadWriteDaoImpl<Answer, Long> implements AnswerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Answer> getAnswerForVote(Long answerId, Long userId) {
        return SingleResultUtil.getSingleResultOrNull(entityManager.createQuery("SELECT answer FROM Answer answer WHERE answer.id = :answerId and answer.user =:userId", Answer.class)
                .setParameter("answerId", answerId)
                .setParameter("userId", userId));
    }

    @Override
    public void updateAnswerSpecial(Answer answer) {
       String hql = "UPDATE Answer answer SET " +
               "answer.id =:id," +
               "answer.htmlBody =:htmlBody," +
               "answer.updateDateTime =:updateDateTime";
       entityManager.createQuery(hql)
               .setParameter("id",answer.getId())
               .setParameter("htmlBody",answer.getHtmlBody())
               .setParameter("updateDateTime",answer.getUpdateDateTime())
               .executeUpdate();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        entityManager.createQuery("update Answer as a set a.isDeleted = true where a.id = :id").setParameter("id", id).executeUpdate();
    }

    @Override
    public Optional<Answer> getById(Long answerId) {
        Query query = entityManager.createQuery("SELECT a FROM Answer a where a.id = :id and a.isDeleted = false")
                .setParameter("id", answerId);
        return SingleResultUtil.getSingleResultOrNull(query);
    }
}
