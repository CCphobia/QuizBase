package com.project.quizbase.exceptions;

public class NoSuchEntityException extends Exception {

    public NoSuchEntityException(){}

    public NoSuchEntityException(String msg){
        super(msg);
    }
}
