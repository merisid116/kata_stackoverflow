package com.javamentor.qa.platform.service.impl.model;

import com.javamentor.qa.platform.dao.abstracts.model.ReputationDao;
import com.javamentor.qa.platform.models.entity.question.Question;
import com.javamentor.qa.platform.models.entity.question.answer.Answer;
import com.javamentor.qa.platform.models.entity.user.User;
import com.javamentor.qa.platform.models.entity.user.reputation.Reputation;
import com.javamentor.qa.platform.models.entity.user.reputation.ReputationType;
import com.javamentor.qa.platform.service.abstracts.model.ReputationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
@Service
public class ReputationServiceImpl extends ReadWriteServiceImpl<Reputation, Long> implements ReputationService {

    private final ReputationDao reputationDao;

    public ReputationServiceImpl(ReputationDao reputationDao) {
        super(reputationDao);
        this.reputationDao = reputationDao;
    }
    @Override
    public Optional<Reputation> getByAuthorAndSenderAndQuestionAndType(User author, User sender, Question question, ReputationType type) {
        return reputationDao.getByAuthorAndSenderAndQuestionAndType(author, sender, question, type);
    }

    @Override
    public Optional<Reputation> getByAnswerIdSenderId(Long senderId, Long answerId) {
        return reputationDao.getByAnswerIdSenderId(senderId,answerId);
    }
}
