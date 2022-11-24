package com.Project_N7.boat_management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_user")
    private Long id_user;

    @Column(name = "name")  //Mapping della colonna
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "date_of_birth")
    private String date_of_birth;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private String gender;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "postal_code")
    private String postal_code;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "boat_licence")
    private String boat_licence;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "is_admin")
    private boolean is_admin;

    @Column(name = "cf")
    public String cf;

    public user() { super(); }

    public Long getId_user() { return id_user; }

    public void setId_user(Long id_user) { this.id_user = id_user; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getDate_of_birth() { return date_of_birth; }

    public void setDate_of_birth(String date_of_birth) { this.date_of_birth = date_of_birth; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getNationality() { return nationality; }

    public void setNationality(String nationality) { this.nationality = nationality; }

    public String getPostal_code() { return postal_code; }

    public void setPostal_code(String postal_code) { this.postal_code = postal_code; }

    public String getPhone_number() { return phone_number; }

    public void setPhone_number(String phone_number) { this.phone_number = phone_number; }

    public String getBoat_licence() { return boat_licence; }

    public void setBoat_licence(String boat_licence) { this.boat_licence = boat_licence; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public boolean isIs_admin() { return is_admin; }

    public void setIs_admin(boolean is_admin) { this.is_admin = is_admin; }

    public String getCf() { return cf; }

    public void setCf(String cf) { this.cf = cf; }

}