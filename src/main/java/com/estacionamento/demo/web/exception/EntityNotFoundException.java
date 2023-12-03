package com.estacionamento.demo.web.exception;


public class EntityNotFoundException  extends  RuntimeException {
    public EntityNotFoundException(String message){
        super(message);
    }
}
