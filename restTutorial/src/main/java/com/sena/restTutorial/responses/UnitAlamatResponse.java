package com.sena.restTutorial.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sena.restTutorial.model.Alamat;

public class UnitAlamatResponse<T> extends BaseResponse{
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("data")
    private T data;


    @JsonCreator
    public UnitAlamatResponse (
            @JsonProperty("status") int status,
            @JsonProperty("message") String message,
            @JsonProperty("data") T data
    ) {
        super(status, message);
        this.data = data;
    }

    @JsonCreator
    public UnitAlamatResponse(
            @JsonProperty("status") int status,
            @JsonProperty("message") String message
    ) {
        super(status, message);
        this.data = null;
    }

    public static UnitAlamatResponse add(Alamat data) {
        return new UnitAlamatResponse(200, "sukses menambahkan data", data);
    }

    public static UnitAlamatResponse update(Alamat data) {
        return new UnitAlamatResponse(200, "sukses memperbarui data", data);
    }

    public static UnitAlamatResponse delete(Alamat data) {
        return new UnitAlamatResponse(200, "sukses menghapus data", data);
    }
}
