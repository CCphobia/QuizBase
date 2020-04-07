package com.project.quizbase.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Game implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "user_id", insertable = false, updatable = false),
            @JoinColumn(name = "quiz_title", insertable = false, updatable = false)
    })
    private Quiz quiz;

    private Integer userScore;

    private Integer maximumScore;

    public Game() {}

    public Game(User user, Quiz quiz){
        this.user = user;
        this.quiz = quiz;
        this.maximumScore = quiz.getQuestions().size();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User player) {
        this.user = player;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Integer getUserScore() {
        return userScore;
    }

    public void setUserScore(Integer playerScore) {
        this.userScore = playerScore;
    }

    public Integer getMaximumScore() {
        return maximumScore;
    }

    public void setMaximumScore(Integer maximumScore) {
        this.maximumScore = maximumScore;
    }

  

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", player=" + user +
                ", quiz=" + quiz +
                ", playerScore=" + userScore +
                ", maximumScore=" + maximumScore +
                '}';
    }
}
