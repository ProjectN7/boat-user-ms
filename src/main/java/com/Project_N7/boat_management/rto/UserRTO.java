package com.Project_N7.boat_management.rto;


public class UserRTO {
    private String cf;
    private String name;
    private String surname;
    private String date_of_birth;
    private String gender;
    private String nationality;
    private String address;
    private String postal_code;
    private String phone_number;
    private String boat_licence;
    private String email;
    private String password;
    private boolean is_admin;

    public UserRTO() { super(); };

    public UserRTO(String cf, String name, String surname, String date_of_birth, String gender, String nationality, String address,
                   String postal_code, String phone_number, String boat_licence, String email, String password, boolean is_admin) {
        super();
        this.cf = cf;
        this.name = name;
        this.surname = surname;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.nationality = nationality;
        this.address = address;
        this.postal_code = postal_code;
        this.phone_number = phone_number;
        this.boat_licence = boat_licence;
        this.email = email;
        this.password = password;
        this.is_admin = is_admin;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
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

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    @Override
    public String toString() {
        return " \"CF\": \"" + cf + "\",\n \"Name\": \"" + name + "\",\n \"Surname\": \"" + surname
                + ",\"\n \"Date of Birth\": \"" + date_of_birth + "\",\n \"Gender\": \"" + gender
                + "\", \n \"Nationality\": \"" + nationality + "\", \n \"Address\": \"" + address
                + "\", \n \"Postal code\": \"" + postal_code + "\", \n \"Phone number\": \"" + phone_number
                + "\", \n \"Boat licence\": \"" + boat_licence + "\", \n \"Email\": \"" + email
                + "\", \n \"Password\": \"" + password + "\", \n \"isAdmin?\": \"" + is_admin + "\", ";
    }
}
