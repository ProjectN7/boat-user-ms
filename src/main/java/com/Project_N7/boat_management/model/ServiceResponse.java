package com.Project_N7.boat_management.model;

import java.time.LocalDateTime;

public class ServiceResponse {
    private String code;
    private String details;
    private String title;
    private String message;
    private Object response;
    private LocalDateTime timestamp;

    /* Da usare solo quando restituisco una Stringa come risposta */
    public ServiceResponse(String code, String details, String title, String message) {
        this.code = code;
        this.details = details;
        this.title = title;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    /* Da usare se devo restituire oggetti aggiuntivi tipo Boat, Pier, etc.*/
    public ServiceResponse(String code, String details, String title, String message, Object response) {
        this.code = code;
        this.details = details;
        this.title = title;
        this.message = message;
        this.response = response;
        this.timestamp = LocalDateTime.now();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
