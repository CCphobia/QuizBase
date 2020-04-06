package com.project.quizbase.dto;

import com.project.quizbase.entities.Category;
import com.project.quizbase.entities.Question;
import com.project.quizbase.entities.Quiz;
import com.project.quizbase.entities.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class QuizDto {

    private User author;
    private String title;
    private Category category;
    private List<Question> questions;
    private LocalDateTime creationTime;

    private QuizDto(){}

    private QuizDto(User author,
                    String title,
                    Category category,
                    List<Question> questions){
        this.author = author;
        this.title = title;
        this.category = category;
        this.questions = questions;
    }

    public User getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public static QuizDto build(
            User author,
            String title,
            Category category,
            List<Question> questions){
        return new QuizDto(author, title, category, questions);
    }

    public Quiz getEntity(){
        return new Quiz(author, title, category, questions);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizDto quizDto = (QuizDto) o;
        return Objects.equals(author, quizDto.author) &&
                Objects.equals(title, quizDto.title) &&
                Objects.equals(category, quizDto.category) &&
                Objects.equals(questions, quizDto.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, category, questions);
    }

    @Override
    public String toString() {
        return "QuizDto{" +
                "author=" + author +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", questions=" + questions +
                ", creationTime=" + creationTime +
                '}';
    }
}
