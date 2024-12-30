package com.enit.service;

public class UserNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    // Default constructor with a predefined message
    public UserNotFoundException() {
        super("User not found");
    }

    // Constructor with a custom message
    public UserNotFoundException(String message) {
        super(message);
    }

    // Constructor with a custom message and cause
    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor with a cause
    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}

