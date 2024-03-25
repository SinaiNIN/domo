package com.example.demo.demojdk21.exception;

public class TaskInterruptedException extends RuntimeException {
    public TaskInterruptedException(String message, Throwable cause) {
        super(message, cause);
    }
}
