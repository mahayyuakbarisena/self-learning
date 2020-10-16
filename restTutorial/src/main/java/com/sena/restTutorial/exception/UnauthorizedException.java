package com.sena.restTutorial.exception;

public class UnauthorizedException extends RuntimeException {

    private String msg;

    public static UnauthorizedException create(String msg) {
        return new UnauthorizedException(msg);
    }

    public UnauthorizedException(String msg) {
        super();
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
