package com.Project_N7.boat_management.to;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static com.Project_N7.boat_management.constants.Constants.*;

public class UserTO {
    @NotBlank(message = NAME_CANNOT_BE_EMPTY)
    @Pattern(regexp = "^[a-z A-Z]+$", message = NAME_INFO)
    private String name;

    @NotBlank(message = SURNAME_CANNOT_BE_EMPTY)
    @Pattern(regexp = "^[a-z A-Z]+$", message = SURNAME_INFO)
    private String surname;

    @NotBlank(message = DATE_OF_BIRTH_CANNOT_BE_EMPTY)
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$", message = DATE_OF_BIRTH_INFO)
    private String dateOfBirth;

    @NotBlank(message = ADDRESS_CANNOT_BE_EMPTY)
    private String address;

    @NotBlank(message = GENDER_CANNOT_BE_EMPTY)
    private String gender;

    @NotBlank(message = NATIONALITY_CANNOT_BE_EMPTY)
    private String nationality;

    @NotBlank(message = POSTAL_CODE_CANNOT_BE_EMPTY)
    @Pattern(regexp = "^[0-9]{5}$", message = POSTAL_CODE_INFO)
    private String postalCode;

    @NotBlank(message = "Il numero di telefono non può essere nullo o vuoto")
    @Pattern(regexp = "^[0-9]{10}$", message = "Il numero di telefono non può contenere lettere o caratteri speciali")
    private String phoneNumber;

    @NotBlank(message = BOAT_LICENCE_CANNOT_BE_EMPTY)
    @Pattern(regexp = "^[A-Z]{2}[0-9]{6}$", message = BOAT_LICENCE_INFO)
    private String boatLicence;

    @NotBlank(message = EMAIL_CANNOT_BE_EMPTY)
    @Pattern(regexp = "^[a-zA-Z0-9.]+@[a-zA-Z]+[.][a-zA-Z]+", message = EMAIL_INFO)
    private String email;

    @NotBlank(message = PASSWORD_CANNOT_BE_EMPTY)
    private String password;


    @NotBlank(message = CF_CANNOT_BE_EMPTY)
    @Pattern(regexp = "[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]", message = CF_INFO)
    private String cf;

    private int isActive;

    public UserTO() { super(); }

    public UserTO(String name, String surname, String dateOfBirth, String address, String gender, String nationality,
                  String postalCode, String phoneNumber, String boatLicence, String email, String password, String cf, int isActive) {
        super();
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.gender = gender;
        this.nationality = nationality;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.boatLicence = boatLicence;
        this.email = email;
        this.password = password;
        this.cf = cf;
        this.isActive = isActive;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBoatLicence() {
        return boatLicence;
    }

    public void setBoatLicence(String boatLicence) {
        this.boatLicence = boatLicence;
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

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
}
