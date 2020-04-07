package com.project.quizbase.repositories;

import com.project.quizbase.entities.Quiz;
import com.project.quizbase.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    boolean existsById_TitleAndId_User(String title, User user);

    @Query(value = "DELETE FROM quiz WHERE ?1 = title AND ?2 = user", nativeQuery = true)
    void deleteByTitleAndAuthor(String title, User user);
}
