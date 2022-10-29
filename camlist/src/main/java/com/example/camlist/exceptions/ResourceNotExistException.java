package com.example.camlist.exceptions;

public class ResourceNotExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    public ResourceNotExistException(String msg) {
        super(msg);
    }

    public ResourceNotExistException(String msg, Throwable cause) {
        super(msg, cause);
    }

}

