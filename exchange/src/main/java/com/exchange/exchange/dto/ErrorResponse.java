package com.exchange.exchange.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse{
    private int status;
    private String message;
    private LocalDateTime timestamp;
    // populated only for validation failures
    private Map<String, String> errors;
    
    public ErrorResponse(int status, String message){
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
    public ErrorResponse(int status, String message, Map<String, String> errors) {
        this(status, message);
        this.errors = errors;
    }
    public int getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public Map<String, String> getErrors() {
        return errors;
    }
}
