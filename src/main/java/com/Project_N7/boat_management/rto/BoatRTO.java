package com.Project_N7.boat_management.rto;

public class BoatRTO {
    private String licence_plate;
    private String name;
    private String colour;
    private String navigation_licence;
    private String power;
    private String declaration_of_conformity;
    private String rca;

    public BoatRTO() { super(); }

    public BoatRTO(String licence_plate, String name, String colour, String navigation_licence, String power,
                   String declaration_of_conformity, String rca) {
        this.licence_plate = licence_plate;
        this.name = name;
        this.colour = colour;
        this.navigation_licence = navigation_licence;
        this.power = power;
        this.declaration_of_conformity = declaration_of_conformity;
        this.rca = rca;
    }

    public String getLicencePlate() {
        return licence_plate;
    }

    public void setLicencePlate(String licence_plate) {
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

    public void setColor(String colour) {
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

    public String toString() {
        return " \"Plate\": \"" + licence_plate + "\",\n \"Name\": \"" + name + "\",\n \"Color\": \"" + colour
                + ",\"\n \"Navigation licence\": \"" + navigation_licence + "\",\n \"Power\": \"" + power
                + "\", \n \"Declaration of conformity\": \"" + declaration_of_conformity + "\", \n \"rca\": \"" + rca
                + "\",";
    }
}
