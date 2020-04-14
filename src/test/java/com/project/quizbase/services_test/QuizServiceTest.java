package com.project.quizbase.services_test;

import com.project.quizbase.dto.QuizDto;
import com.project.quizbase.entities.Category;
import com.project.quizbase.entities.Quiz;
import com.project.quizbase.entities.User;
import com.project.quizbase.exceptions.EntityAlreadyExistsException;
import com.project.quizbase.repositories.CategoryRepository;
import com.project.quizbase.repositories.QuestionRepository;
import com.project.quizbase.repositories.QuizRepository;
import com.project.quizbase.repositories.UserRepository;
import com.project.quizbase.services.QuizService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class QuizServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuizService quizService;

    private final User user = userRepository.getOne(1L);
    private final Category category = categoryRepository.getOne(1L);
    private final QuizDto quizDto = QuizDto.build(
            user,
            "quiz_dto1",
            category,
            questionRepository.findAll()
    );

    @Test
    void testSave() throws EntityAlreadyExistsException {
        assertFalse(
                quizRepository.existsById_UserAndId_Title(user, "quiz_dto1"));
        quizService.saveQuiz(quizDto);
        assertTrue(
                quizRepository.existsById_UserAndId_Title(user, "quiz_dto1"));
    }
}
