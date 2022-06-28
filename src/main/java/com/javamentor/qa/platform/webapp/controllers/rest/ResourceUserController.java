package com.javamentor.qa.platform.webapp.controllers.rest;

import com.javamentor.qa.platform.models.dto.UserDto;
import com.javamentor.qa.platform.service.abstracts.dto.UserDtoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class ResourceUserController {

    private final UserDtoService userDtoService;

    public ResourceUserController(UserDtoService userDtoService) {
        this.userDtoService = userDtoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserDtoById(@PathVariable(value = "id") Long userId) {
        Optional<UserDto> userDto = userDtoService.getById(userId);

        return userDto.isPresent() ?
                ResponseEntity.ok().body(userDto) :
                ResponseEntity.badRequest().body(new UserDto());
    }
}
