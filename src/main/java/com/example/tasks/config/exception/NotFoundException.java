package com.example.tasks.config.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("Not Found");
    }

    public NotFoundException(String message) {
        super("Not Found: " + message);
    }
}
