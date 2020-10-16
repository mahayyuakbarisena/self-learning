package com.sena.restTutorial.exception;

public class ResourceForbiddenException extends RuntimeException {

    private String msg;

    public static ResourceForbiddenException create(String msg) {
        return new ResourceForbiddenException(msg);
    }

    public ResourceForbiddenException(String msg) {
        super();
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
