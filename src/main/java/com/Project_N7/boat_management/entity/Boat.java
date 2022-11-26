package com.Project_N7.boat_management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="boat")
public class Boat {

    @Id
    @Column(name = "plate")
    private String licence_plate;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String colour;

    @Column(name = "navigation_licence")
    private String navigation_licence;

    @Column(name = "power")
    private String power;

    @Column(name = "declaration_of_conformity")
    private String declaration_of_conformity;

    @Column(name = "rca")
    private String rca;


    public Boat() { super(); }

    public String getLicence_plate() {return licence_plate;}

    public void setLicence_plate(String licence_plate) {this.licence_plate = licence_plate;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getNavigation_licence() {
        return navigation_licence;
    }

    public void setNavigation_licence(String navigation_licence) {
        this.navigation_licence = navigation_licence;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDeclaration_of_conformity() {
        return declaration_of_conformity;
    }

    public void setDeclaration_of_conformity(String declaration_of_conformity) { this.declaration_of_conformity = declaration_of_conformity; }

    public String getRca() {
        return rca;
    }

    public void setRca(String rca) {
        this.rca = rca;
    }
}
