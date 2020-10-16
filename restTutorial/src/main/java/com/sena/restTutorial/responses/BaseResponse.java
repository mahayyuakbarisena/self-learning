package com.sena.restTutorial.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseResponse {
    @JsonProperty("status")
    private final Integer status;
    @JsonProperty("message")
    private final String message;

    public BaseResponse(
            Integer status,
            String message
    ) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}

