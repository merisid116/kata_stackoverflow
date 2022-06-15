package com.javamentor.qa.platform.service.impl;

import com.javamentor.qa.platform.models.entity.user.Role;
import com.javamentor.qa.platform.models.entity.user.User;
import com.javamentor.qa.platform.service.abstracts.model.RoleService;
import com.javamentor.qa.platform.service.abstracts.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TestDataInitService {
   private final UserService userService;
   private final RoleService roleService;

   @Autowired
   public TestDataInitService(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Transactional
    public void createEntity() {
        createUsers();
    }


    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private void createUsers() {
        Role userRole = new Role("ROLE_USER");
        roleService.persist(userRole);
        Role adminRole = new Role("ROLE_ADMIN");
        roleService.persist(adminRole);


        User user1 = new User();
        user1.setEmail("user1@mail.ru");
        user1.setFullName("Алеша Попович");
        user1.setAbout("Джун богатырей");
        user1.setCity("Тридевятое государство");
        user1.setImageLink("classpath:static/images/АлешаПопович.png");
        user1.setLastUpdateDateTime(LocalDateTime.now());
        user1.setLinkGitHub("https://github.com/alesha");
        user1.setLinkVk("vk.com");
        user1.setNickname("username1");
        user1.setLinkSite("ссылка на сайт");
        user1.setPassword(passwordEncoder().encode("user1"));
        user1.setPersistDateTime(LocalDateTime.now());
        user1.setRole(userRole);
        user1.setIsEnabled(true);
        userService.persist(user1);

        User admin1 = new User();
        admin1.setEmail("admin1@mail.ru");
        admin1.setFullName("Змей Горыныч");
        admin1.setAbout("трехголовый");
        admin1.setCity("Тридевятое царство");
        admin1.setImageLink("classpath:static/images/ЗмейГорыныч.png");
        admin1.setLastUpdateDateTime(LocalDateTime.now());
        admin1.setLinkGitHub("https://github.com/snake");
        admin1.setLinkVk("ссылка на вк");
        admin1.setNickname("admin");
        admin1.setLinkSite("ссылка на сайт");
        admin1.setPassword(passwordEncoder().encode("admin1"));
        admin1.setPersistDateTime(LocalDateTime.now());
        admin1.setRole(adminRole);
        admin1.setIsEnabled(true);
        userService.persist(admin1);
    }
}
