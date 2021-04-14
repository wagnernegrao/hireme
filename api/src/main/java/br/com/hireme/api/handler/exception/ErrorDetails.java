package br.com.hireme.api.handler.exception;

import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;


public class ErrorDetails {

    private ZonedDateTime timestamp;
    private int status;
    private String error;
    private String exception;
    private String message;
    private String developerMessage;
    private String path;

    public ErrorDetails(ZonedDateTime timestamp, int status, String error, String exception, String message, String developerMessage, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.exception = exception;
        this.message = message;
        this.developerMessage = developerMessage;
        this.path = path;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public String getPath() {
        return path;
    }
}
