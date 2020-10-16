package com.sena.simpletransaction.common.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommonRs<T> {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("status")
    private final int status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("message")
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("data")
    private final T data;

    public CommonRs(int status, String message) {
        super();
        this.status = status;
        this.message = message;
        this.data = null;
    }

    @JsonCreator
    public CommonRs(
            @JsonProperty("status") int status,
            @JsonProperty("message") String message,
            @JsonProperty("data") T data
    ) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
