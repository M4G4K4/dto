package com.korber.dto.utilities.exceptions;

import org.springframework.http.HttpStatus;

import javax.ws.rs.core.Response;

public enum ErrorCode {
    USER_NOT_FOUND("User not found",  Response.Status.BAD_REQUEST.getStatusCode());

    private final String message;
    private final int httpStatusCode;

    ErrorCode(String message, int httpStatusCode) {
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }


    public String getMessage() {
        return message;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }
}
