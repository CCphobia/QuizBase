package com.project.quizbase.entities;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NaturalId
    private String login;

    @Email
    private String email;

    private String password;

    @OneToMany(fetch = FetchType.LAZY,
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            mappedBy = "id.user"
            )
    private List<Quiz> quizzesAdded;

    @OneToMany(fetch = FetchType.LAZY,
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            mappedBy = "user")
    private List<Game> gamesPlayed;

    public User() {}

    public User(String login, String email, String password){
        this.login = login;
        this.email = email;
        this.password = password;
        quizzesAdded = new ArrayList<>();
        gamesPlayed = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Quiz> getQuizzesAdded() {
        return quizzesAdded;
    }

    public void setQuizzesAdded(List<Quiz> quizzesAdded) {
        this.quizzesAdded = quizzesAdded;
    }

    public List<Game> getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(List<Game> gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public void addQuiz(Quiz quiz){
        quizzesAdded.add(quiz);
        quiz.getId().setUser(this);
    }

    public void removeQuiz(Quiz quiz){
        quizzesAdded.remove(quiz);
        quiz.getId().setUser(null);
    }

    public void addGamePlayed(Game game){
        gamesPlayed.add(game);
        game.setUser(this);
    }
    public void removeGamePlayed(Game game){
        gamesPlayed.remove(game);
        game.setUser(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getLogin().equals(user.getLogin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", quizzesAdded=" + quizzesAdded +
                ", gamesPlayed=" + gamesPlayed +
                '}';
    }

}
