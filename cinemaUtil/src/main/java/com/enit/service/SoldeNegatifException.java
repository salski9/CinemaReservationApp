package com.enit.service;

public class SoldeNegatifException extends Exception {
    private static final long serialVersionUID = 1L;

    // Default constructor with a predefined message
    public SoldeNegatifException() {
        super("Votre solde n'est pas suffisant");
    }

    // Constructor with a custom message
    public SoldeNegatifException(String message) {
        super(message);
    }

    // Constructor with a custom message and cause
    public SoldeNegatifException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor with a cause
    public SoldeNegatifException(Throwable cause) {
        super(cause);
    }
}
