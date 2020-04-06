package com.project.quizbase.services_test;

import com.project.quizbase.dto.QuizDto;
import com.project.quizbase.entities.Category;
import com.project.quizbase.entities.Question;
import com.project.quizbase.entities.Quiz;
import com.project.quizbase.entities.User;
import com.project.quizbase.repositories.QuizRepository;
import com.project.quizbase.services.QuizService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.LinkedList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class QuizServiceTest {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuizService quizService;

    private static final User author1 = new User();
    private static final User author2 = new User();
    private final Category category = new Category();
    private final List<Question> questions = new LinkedList<Question>();

    private final String TITLE_1 = "title1";
    private final String TITLE_2 = "title2";

    @BeforeAll
    private static void setUp(){
        author1.setLogin("author1");
        author2.setLogin("author2");
    }

    @AfterEach
    void cleanUp(){
        quizRepository.deleteAll();
    }

    @Test
    void saveQuizTest() throws Exception{
        QuizDto quizDto = QuizDto.build(author1, TITLE_1, category, questions);
        quizService.saveQuiz(quizDto);

        Assertions.assertTrue(quizRepository.count() == 1);
        Assertions.assertTrue(quizRepository.existsById_TitleAndId_Author(TITLE_1, author1));
    }
}
