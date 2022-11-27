package com.Project_N7.boat_management.controller;

import java.util.List;

import com.Project_N7.boat_management.checkerrors.CheckErrorsBoat;
import com.Project_N7.boat_management.exception.LicencePlateException;
import com.Project_N7.boat_management.facade.BoatFacade;
import com.Project_N7.boat_management.rto.BoatRTO;
import com.Project_N7.boat_management.to.BoatTO;
import com.Project_N7.boat_management.to.BoatToModifyTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BoatController {

    @Autowired
    private BoatFacade boat_facade;

    @Autowired
    private CheckErrorsBoat errors;

    @GetMapping(value = "/boat/boatList")
    public ResponseEntity<Object> getBoatFromLicencePlate(@RequestParam String licence_plate) {
        List<BoatRTO> boatRTOs;
        try {
            boatRTOs = boat_facade.getBoatByLicencePlate(licence_plate);
        } catch (LicencePlateException e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        if (boatRTOs.isEmpty()) {
            return new ResponseEntity<>("Nessuna persona associata al CF", HttpStatus.BAD_REQUEST);
        } else {

            return new ResponseEntity<>(boatRTOs,HttpStatus.OK);
        }

    }

    @PostMapping(value = "/boat/boatSave")
    public ResponseEntity<Object> boatSave(@Valid @RequestBody BoatTO boatTO){
        try {
            errors.checkExistLicencePlate(boatTO.getLicence_plate());
        } catch (LicencePlateException e) {
            return new ResponseEntity<>(e.getErrorRTO_list(), e.getHttp_status());
        }
        return new ResponseEntity<>(boat_facade.boatSave(boatTO), HttpStatus.OK);
    }

    @PutMapping(path = "/modificaBoat/{licence_plate}")
    public ResponseEntity<Object> modificaBoat(@Valid @PathVariable("licence_plate") String licence_plate,
                                                  @Valid @RequestBody BoatToModifyTo boatToModifyTO) {

        try {

            errors.checkInformations(licence_plate, boatToModifyTO);

        } catch (LicencePlateException e) {
            return new ResponseEntity<>(e.getErrorRTO_list(), e.getHttp_status());

        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(boat_facade.modificaBoat(licence_plate, boatToModifyTO), HttpStatus.OK);
    }
}
