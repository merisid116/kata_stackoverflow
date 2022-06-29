package com.javamentor.qa.platform.service.abstracts.model;

import com.javamentor.qa.platform.models.entity.question.IgnoredTag;
import com.javamentor.qa.platform.models.entity.question.Tag;
import com.javamentor.qa.platform.models.entity.user.User;

import java.util.Optional;

public interface IgnoredTagService extends ReadWriteService<IgnoredTag,Long>{
    Optional<IgnoredTag> getByUserAndTag(User user, Tag tag);
    IgnoredTag add(Long tagId, User user);
}
