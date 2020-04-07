package com.project.quizbase.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Quiz implements Serializable {

    @EmbeddedId
    QuizId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Category category;

    @OneToMany(fetch = FetchType.LAZY,
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            mappedBy = "quiz")
    private List<Question> questions;

    @CreationTimestamp
    private LocalDateTime creationTime;

    public Quiz(User user, String title, Category category, List<Question> questions) {
        id = new QuizId(user, title);
        this.category = category;
        this.questions = questions;
    }

    public Quiz(){}

    public QuizId getId() {
        return id;
    }

    public void setId(QuizId id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public void addQuestion(Question question){
        questions.add(question);
        question.setQuiz(this);
    }

    public void removeQuestion(Question question){
        questions.remove(question);
        question.setQuiz(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return getId().equals(quiz.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", category=" + category +
                ", questions=" + questions +
                ", creationTime=" + creationTime +
                '}';
    }
}
