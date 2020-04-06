package com.project.quizbase.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QuizId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId
    private User author;

    private String title;

    public QuizId() {}

    public QuizId(User author, String title) {
        this.author = author;
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
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
        return Objects.equals(author, quizId.author) &&
                Objects.equals(title, quizId.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title);
    }

    @Override
    public String toString() {
        return "QuizId{" +
                "author=" + author +
                ", title='" + title + '\'' +
                '}';
    }
}
