package com.testetitan.exceptions;

public class MethodArgumentNotValidException extends RuntimeException{

    public MethodArgumentNotValidException(String msg){
        super(msg);
    }
}
