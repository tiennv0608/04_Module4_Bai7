package com.codegym.exception;

import com.codegym.model.Comment;

public class BadWordException extends Exception {

    private String message;

    public BadWordException(String s) {
        this.message = s;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
