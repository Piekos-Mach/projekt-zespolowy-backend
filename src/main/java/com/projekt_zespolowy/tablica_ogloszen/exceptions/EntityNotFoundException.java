package com.projekt_zespolowy.tablica_ogloszen.exceptions;

public class EntityNotFoundException extends Exception {

    private static final String MESSAGE = "ENTITY NOT FOUND";

    public EntityNotFoundException() {
        super(MESSAGE);
    }

    public EntityNotFoundException(String message) {
        super(MESSAGE);
    }

}
