package com.Project_N7.boat_management.model;

public class Jwtresponse {

    private String jwtToken;

    public Jwtresponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public Jwtresponse() { super(); }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
