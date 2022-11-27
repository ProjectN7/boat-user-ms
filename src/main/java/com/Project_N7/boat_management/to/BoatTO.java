package com.Project_N7.boat_management.to;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class BoatTO {

    @NotBlank(message = "La targa non può essere nulla o vuota")
    @Pattern(regexp = "^[A-Z]{2}-[0-9]{5}$", message = "La targa non può contenere caratteri speciali o non seguire la forma XX00000")
    private String licence_plate;

    @Pattern(regexp = "^[a-z A-Z]+$", message = "Il nome non può contenere numeri o caratteri speciali")
    private String name;

    @Pattern(regexp = "^[a-z A-Z]+$", message = "Il nome non può contenere numeri o caratteri speciali")
    private String colour;

    @NotBlank(message = "La licenza di navigazione non può essere nulla o vuota")
    @Pattern(regexp = "^[A-Z]{2}-[0-9]{4}$", message = "La licenza di navigazione non può contenere caratteri speciali o non seguire la forma XX0000")
    private String navigation_licence;

    @NotBlank(message = "La potenza non può essere nulla o vuota")
    @Pattern(regexp = "^[0-9]{3}$", message = "La potenza non può contenere caratteri speciali o lettere")
    private String power;

    @NotBlank(message = "La dichiarazione di conformità non può essere nulla o vuota")
    @Pattern(regexp = "^[A-Z]{6}-[0-9]{3}$", message = "La dichiarazione di conformità non può contenere caratteri speciali o non seguire la forma XXXXXX000")
    private String declaration_of_conformity;

    @NotBlank(message = "L 'RCA non può essere nulla o vuota")
    @Pattern(regexp = "^[A-Z]{2}-[0-9]{3}$", message = "LL 'RCA non può contenere caratteri speciali o non seguire la forma XX000")
    private String rca;

    public BoatTO() { super(); }

    public BoatTO(String licence_plate, String name, String colour, String navigation_licence, String power,
                  String declaration_of_conformity, String rca) {
        this.licence_plate = licence_plate;
        this.name = name;
        this.colour = colour;
        this.navigation_licence = navigation_licence;
        this.power = power;
        this.declaration_of_conformity = declaration_of_conformity;
        this.rca = rca;
    }

    public String getLicence_plate() {
        return licence_plate;
    }

    public void setLicence_plate(String licence_plate) {
        this.licence_plate = licence_plate;
    }

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

    public void setDeclaration_of_conformity(String declaration_of_conformity) {
        this.declaration_of_conformity = declaration_of_conformity;
    }

    public String getRca() {
        return rca;
    }

    public void setRca(String rca) {
        this.rca = rca;
    }
}
