package org.example;

public class IncorrectPasswordException extends Exception{

    public IncorrectPasswordException(String message) {
        super(message);
    }
}
