package ru.glavatskikh.exceptions;

public class DisciplineNotFoundException extends RuntimeException {
    public DisciplineNotFoundException(String message) {
        super(message);
    }
}
