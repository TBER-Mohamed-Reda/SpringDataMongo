package dev.tber.springbootmongodb.exceptions;

public class ExistingStudentException extends RuntimeException{
    public ExistingStudentException(String message) {
        super(message);
    }
}
