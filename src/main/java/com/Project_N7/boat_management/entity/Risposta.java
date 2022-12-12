package com.Project_N7.boat_management.entity;

public class Risposta {
    private String response;
    private String code;
    private String titolo;


    public Risposta() { super(); }

    public Risposta(String response, String code, String titolo) {
        this.response = response;
        this.code = code;
        this.titolo = titolo;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
}