package com.sena.simpletransaction.common.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BaseResponse<T> {
    @JsonProperty("status")
    private final Integer status;
    @JsonProperty("message")
    private final String message;
    @JsonProperty("data")
    private final T data;

    public BaseResponse(
            Integer status,
            String message,
            T data
    ) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
