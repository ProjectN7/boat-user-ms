package com.Project_N7.boat_management.rto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserCompletoRTO extends UserRTO{
    @JsonIgnore
    private String cf;

    public UserCompletoRTO() { super(); }

    @Override
    public String getCf() {
        return cf;
    }

    @Override
    public void setCf(String cf) {
        this.cf = cf;
    }
}
