package com.javamentor.qa.platform.service.abstracts.model;

import com.javamentor.qa.platform.models.entity.question.answer.Answer;

import java.util.Optional;

public interface AnswerService extends ReadWriteService<Answer,Long> {
    Optional<Answer> getAnswerForVote(Long answerId, Long userId);

    void updateAnswerSpecial(Answer answer);
    void deleteById(Long id);
    Optional<Answer> getById(Long id);
}
