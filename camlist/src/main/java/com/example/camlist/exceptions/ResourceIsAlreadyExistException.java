package com.example.camlist.exceptions;

public class ResourceIsAlreadyExistException extends RuntimeException {


    private static final long serialVersionUID = 1L;

    public ResourceIsAlreadyExistException(String msg) {
        super(msg);
    }

    public ResourceIsAlreadyExistException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
