package com.project.quizbase.services;

import com.project.quizbase.dto.QuizDto;
import com.project.quizbase.entities.User;
import com.project.quizbase.exceptions.EntityAlreadyExistsException;
import com.project.quizbase.exceptions.NoSuchEntityException;
import com.project.quizbase.repositories.QuizRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class QuizService {

    private QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository){
        this.quizRepository = quizRepository;
    }

    @Transactional
    public void saveQuiz(QuizDto quizDto) throws EntityAlreadyExistsException{
        String title = quizDto.getTitle();
        User user = quizDto.getAuthor();

        if (quizRepository.existsById_UserAndId_Title(user, title)) {
            throw new EntityAlreadyExistsException(
                    String.format("Quiz with title %s is already added", title));
        }
        quizRepository.save(quizDto.getEntity());
    }

    @Transactional
    public void deleteQuiz(QuizDto quizDto) throws NoSuchEntityException{
        String title = quizDto.getTitle();
        User user = quizDto.getAuthor();

        if (!quizRepository.existsById_UserAndId_Title(user, title)){
            throw new NoSuchEntityException(
                    String.format("Quiz with title %s does not exists", title));
        }
        quizRepository.deleteByTitleAndAuthor(title, user);
    }
}
