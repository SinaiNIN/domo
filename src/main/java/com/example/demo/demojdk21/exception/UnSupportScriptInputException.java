package com.example.demo.demojdk21.exception;

public class UnSupportScriptInputException extends RuntimeException{
    public UnSupportScriptInputException() {
        super("We're sorry, but we cannot process your input due to security reasons!");
    }
}
