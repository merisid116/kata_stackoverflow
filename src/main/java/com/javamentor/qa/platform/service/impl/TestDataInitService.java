package com.javamentor.qa.platform.service.impl;

import com.javamentor.qa.platform.models.entity.question.Question;
import com.javamentor.qa.platform.models.entity.question.answer.Answer;
import com.javamentor.qa.platform.models.entity.user.Role;
import com.javamentor.qa.platform.models.entity.user.User;
import com.javamentor.qa.platform.service.abstracts.model.AnswerService;
import com.javamentor.qa.platform.service.abstracts.model.QuestionService;
import com.javamentor.qa.platform.service.abstracts.model.RoleService;
import com.javamentor.qa.platform.service.abstracts.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestDataInitService {
   private final UserService userService;
   private final RoleService roleService;
   private final AnswerService answerService;
   private final QuestionService questionService;

   @Autowired
   public TestDataInitService(UserService userService, RoleService roleService,AnswerService answerService, QuestionService questionService) {
        this.userService = userService;
        this.roleService = roleService;
        this.answerService = answerService;
        this.questionService = questionService;
    }

    @Transactional
    public void createEntity() {
       createUsers();
       createQuestions();
       createAnswers();
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

    List<Question> questions = new ArrayList<>();


    private  void createQuestions(){
        Question question1 = new Question();
        question1.setTitle("Title  1");
        question1.setDescription("Description 1");
        question1.setLastUpdateDateTime(LocalDateTime.now());
        question1.setPersistDateTime(LocalDateTime.now());
        question1.setIsDeleted(false);
        questions.add(question1);

        Question question2 = new Question();
        question2.setTitle("Title  2");
        question2.setDescription("Description 2");
        question2.setLastUpdateDateTime(LocalDateTime.now());
        question2.setPersistDateTime(LocalDateTime.now());
        question2.setIsDeleted(false);
        questions.add(question2);

        Question question3 = new Question();
        question3.setTitle("Title  3");
        question3.setDescription("Description 3");
        question3.setLastUpdateDateTime(LocalDateTime.now());
        question3.setPersistDateTime(LocalDateTime.now());
        question3.setIsDeleted(false);
        questions.add(question3);

        Question question4 = new Question();
        question4.setTitle("Title  4");
        question4.setDescription("Description 4");
        question4.setLastUpdateDateTime(LocalDateTime.now());
        question4.setPersistDateTime(LocalDateTime.now());
        question4.setIsDeleted(false);
        questions.add(question4);

        Question question5 = new Question();
        question5.setTitle("Title  5");
        question5.setDescription("Description 5");
        question5.setLastUpdateDateTime(LocalDateTime.now());
        question5.setPersistDateTime(LocalDateTime.now());
        question5.setIsDeleted(false);
        questions.add(question5);

        Question question6 = new Question();
        question6.setTitle("Title  6");
        question6.setDescription("Description 6");
        question6.setLastUpdateDateTime(LocalDateTime.now());
        question6.setPersistDateTime(LocalDateTime.now());
        question6.setIsDeleted(false);
        questions.add(question6);

        questionService.persist(question1);
        questionService.persist(question2);
        questionService.persist(question3);
        questionService.persist(question4);
        questionService.persist(question5);
        questionService.persist(question6);

    }

    List<Answer> answers = new ArrayList<>();

    private void createAnswers(){

       Answer answer1 = new Answer();
       answer1.setHtmlBody("answer 1");
       answer1.setIsDeleted(false);
       answer1.setDateAcceptTime(LocalDateTime.now());
       answer1.setIsHelpful(true);
       answer1.setUpdateDateTime(LocalDateTime.now());
       answer1.setPersistDateTime(LocalDateTime.now());
       answers.add(answer1);

        Answer answer2 = new Answer();
        answer2.setHtmlBody("answer 2");
        answer2.setIsDeleted(false);
        answer2.setDateAcceptTime(LocalDateTime.now());
        answer2.setIsHelpful(true);
        answer2.setUpdateDateTime(LocalDateTime.now());
        answer2.setPersistDateTime(LocalDateTime.now());
        answers.add(answer2);

        Answer answer3 = new Answer();
        answer3.setHtmlBody("answer 3");
        answer3.setIsDeleted(false);
        answer3.setDateAcceptTime(LocalDateTime.now());
        answer3.setIsHelpful(true);
        answer3.setUpdateDateTime(LocalDateTime.now());
        answer3.setPersistDateTime(LocalDateTime.now());
        answers.add(answer3);

        Answer answer4 = new Answer();
        answer4.setHtmlBody("answer 4");
        answer4.setIsDeleted(false);
        answer4.setDateAcceptTime(LocalDateTime.now());
        answer4.setIsHelpful(true);
        answer4.setUpdateDateTime(LocalDateTime.now());
        answer4.setPersistDateTime(LocalDateTime.now());
        answers.add(answer4);

        Answer answer5 = new Answer();
        answer5.setHtmlBody("answer 5");
        answer5.setIsDeleted(false);
        answer5.setDateAcceptTime(LocalDateTime.now());
        answer5.setIsHelpful(true);
        answer5.setUpdateDateTime(LocalDateTime.now());
        answer5.setPersistDateTime(LocalDateTime.now());
        answers.add(answer5);

        Answer answer6 = new Answer();
        answer6.setHtmlBody("answer 6");
        answer6.setIsDeleted(false);
        answer6.setDateAcceptTime(LocalDateTime.now());
        answer6.setIsHelpful(true);
        answer6.setUpdateDateTime(LocalDateTime.now());
        answer6.setPersistDateTime(LocalDateTime.now());
        answers.add(answer6);

        answerService.persist(answer1);
        answerService.persist(answer2);
        answerService.persist(answer3);
        answerService.persist(answer4);
        answerService.persist(answer5);
        answerService.persist(answer6);


    }
}
