package com.project.quizbase.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QuizId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    private String title;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
        return Objects.equals(userId, quizId.userId) &&
                Objects.equals(title, quizId.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, title);
    }

    @Override
    public String toString() {
        return "QuizId{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                '}';
    }
}
