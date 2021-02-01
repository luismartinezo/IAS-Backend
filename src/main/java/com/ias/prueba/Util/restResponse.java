package com.ias.prueba.Util;

public class restResponse {

    private Integer responseCode;
    private String message;

    public restResponse(Integer responseCode) {
        super();
        this.responseCode = responseCode;
    }

    public restResponse(Integer responseCode, String message) {
        super();
        this.responseCode = responseCode;
        this.message = message;

    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}