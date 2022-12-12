package com.Project_N7.boat_management.to;


public class UserToModifyTO {
    private String address;
    private String postal_code;
    private String phone_number;
    private String boat_licence;
    private String email;
    private String password;

    public UserToModifyTO() { super(); }

    public UserToModifyTO(String address, String postal_code, String phone_number, String boat_licence, String email, String password) {
        this.address = address;
        this.postal_code = postal_code;
        this.phone_number = phone_number;
        this.boat_licence = boat_licence;
        this.email = email;
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
