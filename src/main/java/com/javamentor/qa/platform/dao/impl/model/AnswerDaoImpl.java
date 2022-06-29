package com.javamentor.qa.platform.dao.impl.model;

import com.javamentor.qa.platform.dao.abstracts.model.AnswerDao;
import com.javamentor.qa.platform.dao.util.SingleResultUtil;
import com.javamentor.qa.platform.models.entity.question.answer.Answer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public void deleteById(Long id) {super.deleteById(id);}

    public Optional<Answer> getById(Long id){
        Answer answer = new Answer();
        answer.setIsDeleted(false);
        return super.getById(id);
    }

}
