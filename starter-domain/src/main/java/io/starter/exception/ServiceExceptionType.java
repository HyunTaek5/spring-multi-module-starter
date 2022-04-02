package io.starter.exception;


import org.springframework.http.HttpStatus;

public enum ServiceExceptionType {
    SERVER_ERROR,
    NOT_VERIFIED_USER,
    AUTHORIZED_ERROR,
    EMAIL_DUPLICATED,
    PHONE_DUPLICATED,
    NOT_FOUND;

    private String message;
    private HttpStatus status;

    ServiceExceptionType() {

    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String message) {
        this.message = message;
    }

    public final HttpStatus getStatus() {
        return this.status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    private ServiceExceptionType(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
