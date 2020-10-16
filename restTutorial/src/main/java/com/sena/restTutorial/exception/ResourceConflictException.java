package com.sena.restTutorial.exception;

public class ResourceConflictException extends RuntimeException {

    private String msg;

    public static ResourceConflictException create(String msg) {
        return new ResourceConflictException(msg);
    }

    public ResourceConflictException(String msg) {
        super();
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }

}
