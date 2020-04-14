package com.project.quizbase.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Question implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private String body;

    @ElementCollection
    @CollectionTable(
        joinColumns = @JoinColumn(name = "question_id")
    )
    private List<String> answers;

    private String correctAnswer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns(value = {
            @JoinColumn(name = "quiz_title"),
            @JoinColumn(name = "user_id")
    })
    private Quiz quiz;

    public Question() {}

    public Question(String body,
                    List<String> answers,
                    String correctAnswer,
                    Quiz quiz){

        this.body = body;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
        this.quiz = quiz;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return getBody().equals(question.getBody()) &&
                getQuiz().equals(question.getQuiz());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBody(), getQuiz());
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", answers=" + answers +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", quiz=" + quiz +
                '}';
    }
}
