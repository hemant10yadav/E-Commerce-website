package com.e_com.exception_handler;

public class ExceptionMessage {

    private int status;
    private String message;
    private Long timestamp;

    public ExceptionMessage() {
    }

    public ExceptionMessage(int status, String message, Long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public ExceptionMessage(String message) {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
