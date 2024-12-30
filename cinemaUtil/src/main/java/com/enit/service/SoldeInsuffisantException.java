package com.enit.service;

public class SoldeInsuffisantException extends Exception {
    private static final long serialVersionUID = 1L;

    // Default constructor with a predefined message
    public SoldeInsuffisantException() {
        super("Solde insuffisant :( ");
    }

    // Constructor with a custom message
    public SoldeInsuffisantException(String message) {
        super(message);
    }

    // Constructor with a custom message and cause
    public SoldeInsuffisantException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor with a cause
    public SoldeInsuffisantException(Throwable cause) {
        super(cause);
    }
}

