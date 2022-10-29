package com.example.camlist.exceptions;

public class ResourceSaveException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    public ResourceSaveException(String msg) {
        super(msg);
    }

    public ResourceSaveException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
