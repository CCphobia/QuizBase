package com.project.quizbase.exceptions;

public class EntityAlreadyExistsException extends Exception {

    public EntityAlreadyExistsException(){}

    public EntityAlreadyExistsException(String msg){
        super(msg);
    }
}
