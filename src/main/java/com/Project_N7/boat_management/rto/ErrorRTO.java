package com.Project_N7.boat_management.rto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ErrorRTO {

    @JsonInclude(Include.NON_NULL)
    private String field;

    private String message;

    public ErrorRTO() {
        super();
    }

    public ErrorRTO(String message) {
        super();
        this.message = message;
    }

    public ErrorRTO(String field, String message) {
        super();
        this.message = message;
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
