package com.Project_N7.boat_management.facade;
import com.Project_N7.boat_management.exception.CfException;
import com.Project_N7.boat_management.exception.LicencePlateException;
import com.Project_N7.boat_management.rto.BoatCompletaRTO;
import com.Project_N7.boat_management.rto.BoatRTO;
import com.Project_N7.boat_management.rto.UserRTO;
import com.Project_N7.boat_management.service.BoatService;
import com.Project_N7.boat_management.service.UserService;

import com.Project_N7.boat_management.to.BoatTO;
import com.Project_N7.boat_management.to.BoatToModifyTo;
import com.Project_N7.boat_management.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoatFacade {
    @Autowired
    BoatService boatService;

    public List<BoatRTO> getBoatByLicencePlate(String licence_plate) throws LicencePlateException {
        if (!boatService.licencePlateExist(licence_plate)) { // Prima chiamata al server per vedere se il
            // la patente nautica esiste
            throw new LicencePlateException("patente nautica non presente"); // Altrimenti lancio l'eccezione
        }
        // Se il numero è presente vado a cercarmi le persone che lo posseggono
        return boatService.getBoatByLicencePlate(licence_plate);
    }

    public String boatSave(BoatTO boatTO) {
        String licence_plate = boatService.boatSave(boatTO);
        if (licence_plate != null) {
            return "La barca con la patente nautica: " + licence_plate + "è stata aggiunta";
        }

        return "La barca non è stata inserita";
    }

    public BoatCompletaRTO modificaBoat(String licence_plate, BoatToModifyTo boatToModifyTO) {
        return boatService.modificaBoat(licence_plate, boatToModifyTO);
    }

}