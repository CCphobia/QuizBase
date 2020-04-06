package com.project.quizbase.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;

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
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Question> questions;

    @CreationTimestamp
    private LocalDateTime creationTime;

    public Quiz(User author, String title, Category category, List<Question> questions) {
        id = new QuizId(author, title);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return Objects.equals(id, quiz.id) &&
                Objects.equals(category, quiz.category) &&
                Objects.equals(questions, quiz.questions) &&
                Objects.equals(creationTime, quiz.creationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, questions, creationTime);
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
