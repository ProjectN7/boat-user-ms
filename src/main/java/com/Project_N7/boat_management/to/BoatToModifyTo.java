package com.Project_N7.boat_management.to;


public class BoatToModifyTo {
    private String name;

    private String colour;

    private String navigation_licence;

    private String power;

    private String declaration_of_conformity;

    private String rca;

    public BoatToModifyTo() { super(); }

    public BoatToModifyTo(String name, String colour, String navigation_licence,
                          String power, String declaration_of_conformity, String rca) {
        this.name = name;
        this.colour = colour;
        this.navigation_licence = navigation_licence;
        this.power = power;
        this.declaration_of_conformity = declaration_of_conformity;
        this.rca = rca;
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
