package com.Project_N7.boat_management.to;


public class UserToModifyTO {
    private String address;
    private String postalCode;
    private String phoneNumber;
    private String boatLicence;
    private String email;
    private String password;

    public UserToModifyTO() { super(); }

    public UserToModifyTO(String address, String postalCode, String phoneNumber, String boatLicence, String email, String password) {
        this.address = address;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.boatLicence = boatLicence;
        this.email = email;
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
