package com.sena.restTutorial.exception;

public class ResourceNotFoundException extends RuntimeException {

    private String msg;

    public static ResourceNotFoundException create(String msg) {
        return new ResourceNotFoundException(msg);
    }

    public ResourceNotFoundException(String msg) {
        super();
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
