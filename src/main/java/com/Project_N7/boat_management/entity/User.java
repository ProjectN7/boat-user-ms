package com.Project_N7.boat_management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name = "cf")
    public String cf;

    @Column(name = "name")  //Mapping della colonna
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "dateOfBirth")
    private String dateOfBirth;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private String gender;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "boatLicence")
    private String boatLicence;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "isAdmin")
    private boolean isAdmin;

    @Column(name = "isActive")
    private int isActive;

    public User() { super(); }


    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getDateOfBirth() { return dateOfBirth; }

    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getNationality() { return nationality; }

    public void setNationality(String nationality) { this.nationality = nationality; }

    public String getPostalCode() { return postalCode; }

    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getBoatLicence() { return boatLicence; }

    public void setBoatLicence(String boatLicence) { this.boatLicence = boatLicence; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public boolean isAdmin() { return isAdmin; }

    public void setAdmin(boolean admin) { this.isAdmin = admin; }

    public String getCf() { return cf; }

    public void setCf(String cf) { this.cf = cf; }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
}