package com.Project_N7.boat_management.to;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static com.Project_N7.boat_management.constants.Constants.*;

public class UserToModifyTO {

    private String name;

    private String surname;

    private String dateOfBirth;

    private String address;

    private String gender;

    private String nationality;

    private String postalCode;

    private String phoneNumber;

    private String boatLicence;

    private String email;

    private String password;

    private String cf;

    private int isActive;

    public UserToModifyTO() { super(); }

    public UserToModifyTO(String name, String surname, String dateOfBirth, String address, String gender, String nationality,
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
