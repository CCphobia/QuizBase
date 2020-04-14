package com.project.quizbase.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QuizId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    public QuizId() {}

    public QuizId(User user, String title) {
        this.user = user;
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User author) {
        this.user = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizId quizId = (QuizId) o;
        return Objects.equals(user, quizId.user) &&
                Objects.equals(title, quizId.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, title);
    }

    @Override
    public String toString() {
        return "QuizId{" +
                "author=" + user +
                ", title='" + title + '\'' +
                '}';
    }
}
