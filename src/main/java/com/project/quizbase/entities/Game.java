package com.project.quizbase.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Game implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User player;

    @ManyToOne(fetch = FetchType.LAZY)
    private Quiz quiz;

    @Column(name = "player_score")
    private Integer playerScore;

    @Column(name = "maximum_score")
    private Integer maximumScore;

    public Game() {}

    public Game(User player, Quiz quiz){
        this.player = player;
        this.quiz = quiz;
        this.maximumScore = quiz.getQuestions().size();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Integer getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(Integer playerScore) {
        this.playerScore = playerScore;
    }

    public Integer getMaximumScore() {
        return maximumScore;
    }

    public void setMaximumScore(Integer maximumScore) {
        this.maximumScore = maximumScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) &&
                Objects.equals(player, game.player) &&
                Objects.equals(quiz, game.quiz) &&
                Objects.equals(playerScore, game.playerScore) &&
                Objects.equals(maximumScore, game.maximumScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, player, quiz, playerScore, maximumScore);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", player=" + player +
                ", quiz=" + quiz +
                ", playerScore=" + playerScore +
                ", maximumScore=" + maximumScore +
                '}';
    }
}
