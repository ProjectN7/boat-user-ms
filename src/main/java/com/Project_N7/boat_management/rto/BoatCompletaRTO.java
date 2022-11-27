package com.Project_N7.boat_management.rto;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class BoatCompletaRTO extends BoatRTO {

    @JsonIgnore
    private String licence_plate;

    public BoatCompletaRTO() { super(); }

    public String getLicence_plate() {
        return licence_plate;
    }

    public void setLicence_plate(String licence_plate) {
        this.licence_plate = licence_plate;
    }
}
