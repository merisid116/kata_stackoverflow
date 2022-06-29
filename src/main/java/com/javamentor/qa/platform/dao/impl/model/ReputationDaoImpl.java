package com.javamentor.qa.platform.dao.impl.model;

import com.javamentor.qa.platform.dao.abstracts.model.ReputationDao;
import com.javamentor.qa.platform.dao.util.SingleResultUtil;
import com.javamentor.qa.platform.models.entity.question.Question;
import com.javamentor.qa.platform.models.entity.user.User;
import com.javamentor.qa.platform.models.entity.user.reputation.Reputation;
import com.javamentor.qa.platform.models.entity.user.reputation.ReputationType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class ReputationDaoImpl extends ReadWriteDaoImpl<Reputation, Long> implements ReputationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Reputation> getByAuthorAndSenderAndQuestionAndType(User author, User sender, Question question, ReputationType type) {
        return SingleResultUtil.getSingleResultOrNull(entityManager.createQuery
                        ("SELECT r FROM Reputation r WHERE r.author = :author and r.sender =:sender and r.question =:question and r.type =:type",
                                Reputation.class)
                .setParameter("author", author)
                .setParameter("sender", sender)
                .setParameter("question", question)
                .setParameter("type", type));
    }

    @Override
    public Optional<Reputation> getByAnswerIdSenderId(Long senderId, Long answerId) {
        return SingleResultUtil.getSingleResultOrNull(entityManager.createQuery
                ("SELECT r FROM Reputation r WHERE r.answer.id =:answerId and r.sender.id =:senderId", Reputation.class)
                .setParameter("answerId", answerId)
                .setParameter("senderId", senderId));
    }
}
