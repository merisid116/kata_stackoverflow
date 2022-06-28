package com.javamentor.qa.platform.dao.impl.model.dto;

import com.javamentor.qa.platform.dao.abstracts.model.dto.UserDtoDao;
import com.javamentor.qa.platform.dao.util.SingleResultUtil;
import com.javamentor.qa.platform.models.dto.UserDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;
@Repository
public class UserDtoDaoImpl implements UserDtoDao{

    @PersistenceContext
    private EntityManager entityManager;

    public UserDtoDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<UserDto> getById(Long id){
        return SingleResultUtil.getSingleResultOrNull(entityManager
                .createQuery("SELECT u.id, u.email, u.fullName," +
                "u.imageLink, u.city, SUM (r.count) " +
                "FROM User u" +
                        " INNER JOIN Reputation r ON u.id = r.author.id " +
                                "WHERE u.id = :userId"
                , UserDto.class)
                .setParameter("userId", id));
    }
}
