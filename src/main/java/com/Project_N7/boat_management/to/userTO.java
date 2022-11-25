package com.Project_N7.boat_management.to;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class userTO {
    @NotBlank(message = "Il nome non può essere nullo o vuoto")
    @Pattern(regexp = "^[a-z A-Z]+$", message = "Il nome non può contenere numeri o caratteri speciali")
    private String name;

    @NotBlank(message = "Il cognome non può essere nullo o vuoto")
    @Pattern(regexp = "^[a-z A-Z]+$", message = "Il cognome non può contenere numeri o caratteri speciali")
    private String surname;

    @NotBlank(message = "La data di nascita non può essere nulla o vuota")
    @Pattern(regexp = "^[0-9]{2}[0-9]{2}[0-9]{4}$", message = "La data di nascita non può contenere lettere o caratteri speciali")
    private String date_of_birth;

    @NotBlank(message = "L'indirizzo non può essere nullo o vuoto")
    private String address;

    @NotBlank(message = "Il sesso non può essere nullo o vuoto")
    private String gender;

    @NotBlank(message = "La nazionalità non può essere nullo o vuoto")
    private String nationality;

    @NotBlank(message = "Il codice postale non può essere nullo o vuoto")
    @Pattern(regexp = "^[0-9]{5}$", message = "Il codice postale non può contenere lettere o caratteri speciali")
    private String postal_code;

    @NotBlank(message = "Il numero di telefono non può essere nullo o vuoto")
    @Pattern(regexp = "^[0-9]{10}$", message = "Il numero di telefono non può contenere lettere o caratteri speciali")
    private String phone_number;

    @NotBlank(message = "La patente nautica non può essere nullo o vuoto")
    @Pattern(regexp = "^[A-Z]{2}[0-9]{6}$", message = "Patente nautica non valida")
    private String boat_licence;

    @NotBlank(message = "La mail non può essere nulla o vuota")
    @Pattern(regexp = "^[a-zA-Z0-9.]+@[a-zA-Z]+[.][a-zA-Z]+", message = "Mail non valida, inserire una mail example@domain.com")
    private String email;

    @NotBlank(message = "La password non può essere nulla o vuota")
    private String password;


    @NotBlank(message = "Il codice fiscale non può essere nullo o vuoto")
    @Pattern(regexp = "[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]", message = "Codice fiscale non valido")
    private String cf;

    public userTO() { super(); }

    public userTO(String name, String surname, String date_of_birth, String address, String gender, String nationality,
                  String postal_code, String phone_number, String boat_licence, String email, String password, String cf) {
        super();
        this.name = name;
        this.surname = surname;
        this.date_of_birth = date_of_birth;
        this.address = address;
        this.gender = gender;
        this.nationality = nationality;
        this.postal_code = postal_code;
        this.phone_number = phone_number;
        this.boat_licence = boat_licence;
        this.email = email;
        this.password = password;
        this.cf = cf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getBoat_licence() {
        return boat_licence;
    }

    public void setBoat_licence(String boat_licence) {
        this.boat_licence = boat_licence;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }
}
