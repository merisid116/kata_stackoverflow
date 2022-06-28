package com.javamentor.qa.platform.service.abstracts.model.dto;

import com.javamentor.qa.platform.models.dto.UserDto;
import com.javamentor.qa.platform.service.abstracts.model.ReadWriteService;

import java.util.Optional;

public interface UserDtoService {
    Optional<UserDto> getById(Long id);
}
