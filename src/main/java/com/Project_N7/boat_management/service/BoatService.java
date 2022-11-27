package com.Project_N7.boat_management.service;

import com.Project_N7.boat_management.entity.Boat;
import com.Project_N7.boat_management.repository.BoatRepository;
import com.Project_N7.boat_management.rto.BoatCompletaRTO;
import com.Project_N7.boat_management.rto.BoatRTO;
import com.Project_N7.boat_management.to.BoatTO;
import com.Project_N7.boat_management.to.BoatToModifyTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BoatService {

    @Autowired
    private BoatRepository boat_repository;

    public List<BoatRTO> getBoatByLicencePlate(String licence_plate) {

        // Chiamo il metodo trasferisciDaPersonaAPersonaRto per popolarla con i dati che
        // mi servono
        return convertBoatTOBoatRTO(boat_repository.getBoatByLicencePlate(licence_plate));
    }

    public boolean licencePlateExist(String licence_plate) { return (boat_repository.findBoatFromLicencePlate(licence_plate) != null); }

    public String boatSave(BoatTO boatTO) {
        Boat boat_to_save = new Boat();
        boat_to_save.setLicence_plate(boatTO.getLicence_plate());
        boat_to_save.setName(boatTO.getName());
        boat_to_save.setColour(boatTO.getColour());
        boat_to_save.setNavigation_licence(boatTO.getNavigation_licence());
        boat_to_save.setPower(boatTO.getPower());
        boat_to_save.setDeclaration_of_conformity(boatTO.getDeclaration_of_conformity());
        boat_to_save.setRca(boatTO.getRca());
        return boat_repository.save(boat_to_save).getLicence_plate();
    }

    private List<BoatRTO> convertBoatTOBoatRTO(List<Boat> boat_list) {

        // Creo la lista di PersonaRTO
        List<BoatRTO> boatRTOList = new ArrayList<>();
        // Ciclo for per passare una ad una le persone dall'entità completa
        // all'oggetto custom RTO contenente solo le informazioni che vogliamo
        for (Boat boat : boat_list) {

            // Creazione della PersonaRTO temporanea
            BoatRTO boatRTO_temp = populateBoatRTO(boat);

            // Inserimento della PersonaRTO temporanea in nella lista di personeRto
            boatRTOList.add(boatRTO_temp);
        }
        return boatRTOList;
    }

    private BoatRTO populateBoatRTO(Boat boat) {
        BoatRTO boatRTO_temp = new BoatRTO();

        // Popolamento tramite setter e getter
        boatRTO_temp.setLicencePlate(boat.getLicence_plate());
        boatRTO_temp.setName(boat.getName());
        boatRTO_temp.setColor(boat.getColour());
        boatRTO_temp.setNavigation_licence(boat.getNavigation_licence());
        boatRTO_temp.setPower(boat.getPower());
        boatRTO_temp.setDeclaration_of_conformity(boat.getDeclaration_of_conformity());
        boatRTO_temp.setRca(boat.getRca());
        return boatRTO_temp;
    }

    public BoatCompletaRTO modificaBoat(String licence_plate, BoatToModifyTo personaToModifyTO) {
        Boat boatTemp = boat_repository.getById(licence_plate);
        cambiaNotNull(boatTemp, personaToModifyTO);
        return convertBoatToBoatCompletaRTO(boat_repository.save(boatTemp));

    }
    public void cambiaNotNull(Boat boatTemp, BoatToModifyTo boatToModifyTO) {

        boatTemp.setName(boatToModifyTO.getName() != null ? boatToModifyTO.getName() : boatTemp.getName());
        boatTemp.setColour(
                boatToModifyTO.getColour() != null ? boatToModifyTO.getColour() : boatTemp.getColour());
        boatTemp
                .setNavigation_licence(boatToModifyTO.getNavigation_licence() != null ? boatToModifyTO.getNavigation_licence() :
                        boatTemp.getNavigation_licence());
        boatTemp.setPower(boatToModifyTO.getPower() != null ? boatToModifyTO.getPower()
                : boatTemp.getPower());
        boatTemp
                .setDeclaration_of_conformity(boatToModifyTO.getDeclaration_of_conformity() != null ? boatToModifyTO.getDeclaration_of_conformity() :
                        boatTemp.getDeclaration_of_conformity());
        boatTemp.setRca(boatToModifyTO.getRca() != null ? boatToModifyTO.getRca()
                : boatTemp.getRca());
    }
    private BoatCompletaRTO convertBoatToBoatCompletaRTO(Boat boat) {
        BoatCompletaRTO boatCompletaRtoTemp = new BoatCompletaRTO();

        // Popolamento tramite setter e getter
        boatCompletaRtoTemp.setLicence_plate(boat.getLicence_plate());
        boatCompletaRtoTemp.setName(boat.getName());
        boatCompletaRtoTemp.setColor(boat.getColour());
        boatCompletaRtoTemp.setNavigation_licence(boat.getNavigation_licence());
        boatCompletaRtoTemp.setPower(boat.getPower());
        boatCompletaRtoTemp.setDeclaration_of_conformity(boat.getDeclaration_of_conformity());
        boatCompletaRtoTemp.setRca(boat.getRca());
        return boatCompletaRtoTemp;
    }
}
