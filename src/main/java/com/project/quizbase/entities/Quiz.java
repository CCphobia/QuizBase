package com.project.quizbase.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "quiz")
public class Quiz implements Serializable {

    @EmbeddedId
    private QuizId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("user_id")
    private User creator;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Question> questions;

    @CreationTimestamp
    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    public Quiz(String title, Category category, List<Question> questions) {
        this.title = title;
        this.category = category;
        this.questions = questions;
    }

    public Quiz(){}

    public QuizId getId() {
        return id;
    }

    public void setId(QuizId idQ) {
        this.id = idQ;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
                Objects.equals(creator, quiz.creator) &&
                Objects.equals(title, quiz.title) &&
                Objects.equals(category, quiz.category) &&
                Objects.equals(questions, quiz.questions) &&
                Objects.equals(creationTime, quiz.creationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creator, title, category, questions, creationTime);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", creator=" + creator +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", questions=" + questions +
                ", creationTime=" + creationTime +
                '}';
    }
}
