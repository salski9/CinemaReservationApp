package com.enit.service;

public class PlusDePlaceException extends Exception {
    private static final long serialVersionUID = 1L;

    // Default constructor with a predefined message
    public PlusDePlaceException() {
        super("Il n'y a plus de places disponibles");
    }

    // Constructor with a custom message
    public PlusDePlaceException(String message) {
        super(message);
    }

    // Constructor with a custom message and cause
    public PlusDePlaceException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor with a cause
    public PlusDePlaceException(Throwable cause) {
        super(cause);
    }
}
