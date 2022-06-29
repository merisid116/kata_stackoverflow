package com.javamentor.qa.platform.service.impl.model;

import com.javamentor.qa.platform.dao.abstracts.model.AnswerDao;
import com.javamentor.qa.platform.models.entity.question.answer.Answer;
import com.javamentor.qa.platform.service.abstracts.model.AnswerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AnswerServiceImpl extends ReadWriteServiceImpl<Answer, Long> implements AnswerService {

    private final AnswerDao answerDao;

    public AnswerServiceImpl(AnswerDao answerDao) {
        super(answerDao);
        this.answerDao = answerDao;
    }

    @Override
    public Optional<Answer> getAnswerForVote(Long answerId, Long userId) {
        return answerDao.getAnswerForVote(answerId,userId);
    }

    @Override
    public void updateAnswerSpecial(Answer answer) {
        answerDao.updateAnswerSpecial(answer);
    }

    @Override
    public void deleteById(Long id){
        answerDao.deleteById(id);
    }
    @Override
    public Optional<Answer> getById(Long id){
        return answerDao.getById(id);
    }
}
