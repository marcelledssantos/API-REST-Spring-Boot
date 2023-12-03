package com.estacionamento.demo.web.exception;

public class PasswordInvalidException extends RuntimeException {
    public PasswordInvalidException(String message) {
        super(message);
    }
}
