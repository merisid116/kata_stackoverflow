package com.javamentor.qa.platform.webapp.controllers.rest;

import com.javamentor.qa.platform.exception.ResourceNotFoundException;
import com.javamentor.qa.platform.models.dto.UserDto;
import com.javamentor.qa.platform.service.abstracts.model.dto.UserDtoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/api/user")
public class ResourceUserController {

    private final UserDtoService uds;

    public ResourceUserController(UserDtoService uds) {
        this.uds = uds;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getUserDtoById(@PathVariable(value = "id") Long userId) {
        Optional<UserDto> userDto = uds.getById(userId);
        return userDto.isPresent() ? ResponseEntity.ok().body(userDto.get()):
                ResponseEntity.badRequest()
                        .body(String.format("No question with ID %d",userId));
    }

    //    @GetMapping
//    public ResponseEntity<List<User>> getPage(){
//        final List<User> users = userService.getAll();
//        return  users != null && !users.isEmpty()
//                ? new ResponseEntity<>(users, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
}
