package com.javamentor.qa.platform.service.impl.dto;

import com.javamentor.qa.platform.dao.abstracts.model.dto.UserDtoDao;
import com.javamentor.qa.platform.models.dto.UserDto;
import com.javamentor.qa.platform.service.abstracts.model.dto.UserDtoService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDtoServiceImpl implements UserDtoService {

   private final UserDtoDao dao;

    public UserDtoServiceImpl(UserDtoDao dao) {this.dao = dao;}

    @Override
    public Optional<UserDto> getById(Long id) {
        return dao.getById(id);
    }
}
