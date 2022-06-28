package com.javamentor.qa.platform.service.impl.dto;

import com.javamentor.qa.platform.dao.abstracts.dto.UserDtoDao;
import com.javamentor.qa.platform.models.dto.UserDto;
import com.javamentor.qa.platform.service.abstracts.dto.UserDtoService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDtoServiceImpl implements UserDtoService {

    private final UserDtoDao userDtoDao;

    public UserDtoServiceImpl(UserDtoDao dao) {
        this.userDtoDao = dao;
    }

    @Override
    public Optional<UserDto> getById(Long id) {
        return userDtoDao.getById(id);
    }
}
