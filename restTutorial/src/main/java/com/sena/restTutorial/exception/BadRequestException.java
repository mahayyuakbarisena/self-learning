package com.sena.restTutorial.exception;

/**
 * @author Dzaki Buchori on 18/09/2020 13:13
 */
public class BadRequestException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -1660172094856444899L;

    private String msg;

    public static BadRequestException create(String msg) {
        return new BadRequestException(msg);
    }

    public BadRequestException(String msg) {
        super();
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }

}
