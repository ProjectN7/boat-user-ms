package com.Project_N7.boat_management.checkerrors;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


import com.Project_N7.boat_management.exception.LicencePlateException;
import com.Project_N7.boat_management.rto.ErrorRTO;
import com.Project_N7.boat_management.service.BoatService;
import com.Project_N7.boat_management.to.BoatToModifyTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

//@Component
@Service
public class CheckErrorsBoat {

    @Autowired
    private BoatService boatService;

    public void checkIdList(List<Long> ids) throws LicencePlateException {

        List<ErrorRTO> errorRTO_list = new ArrayList<>();
        if (CollectionUtils.isEmpty(ids)) {
            errorRTO_list.add(new ErrorRTO("Non è stato inserito nessun id per la ricerca!"));
            throw new LicencePlateException(errorRTO_list, HttpStatus.NOT_FOUND); // Lancio subito poichè voglio che un
            // differente HttpStatus
        }

        List<ErrorRTO> errorRtoListClear = new ArrayList<>();
        for (ErrorRTO errorRtoTemp : errorRTO_list) {
            if (errorRtoTemp != null) {
                errorRtoListClear.add(errorRtoTemp);
            }
        }

        // Lancio dell'eccezione
        if (!errorRtoListClear.isEmpty()) {
            throw new LicencePlateException(errorRTO_list, HttpStatus.BAD_REQUEST);
        }
    }


    public ErrorRTO checkIfNull(Long id) {
        if (id == null) {
            return new ErrorRTO("null inserito nella lista");
        }
        return null;
    }

    public void checkExistLicencePlate(String licence_plate) throws LicencePlateException {
        List<ErrorRTO> errorRTO_list = new ArrayList<>();
        if (boatService.licencePlateExist(licence_plate)) {
            errorRTO_list.add(new ErrorRTO(
                    "Esiste già una persona con questo codice fiscale"));
        }
        if (!errorRTO_list.isEmpty()) {
            throw new LicencePlateException(errorRTO_list, HttpStatus.CONFLICT);
        }
    }
    public void checkInformations(String licence_plate, BoatToModifyTo boatToModifyTO)
            throws LicencePlateException, IllegalArgumentException, IllegalAccessException {

        checkLicencePlateExist(licence_plate);
        List<ErrorRTO> errorRtoList = new ArrayList<>();

        if (boatToModifyTO.getName() != null && !boatToModifyTO.getName().matches("^[a-z A-Z]+$")) {
            errorRtoList.add(new ErrorRTO("Name", "Campo non valido"));
        }

        if (boatToModifyTO.getColour() != null && !boatToModifyTO.getColour().matches("^[a-z A-Z]+$")) {
            errorRtoList.add(new ErrorRTO("Colour", "Campo non valido"));
        }

        if (boatToModifyTO.getNavigation_licence() != null && !boatToModifyTO.getNavigation_licence().matches("^[A-Z]{2}-[0-9]{4}$")) {
            errorRtoList.add(new ErrorRTO("Navigation Licence", "Campo non valido"));
        }

        if (boatToModifyTO.getPower() != null && !boatToModifyTO.getPower().matches("^[0-9]{3}$")) {
            errorRtoList.add(new ErrorRTO("Power", "Campo non valido"));
        }

        if (boatToModifyTO.getDeclaration_of_conformity() != null
                && !boatToModifyTO.getDeclaration_of_conformity().matches("^[A-Z]{6}-[0-9]{3}$")) {
            errorRtoList.add(new ErrorRTO("Declaration of conformity", "Campo non valido"));
        }

        if (boatToModifyTO.getRca() != null
                && !boatToModifyTO.getRca().matches("^[A-Z]{2}-[0-9]{3}$")) {
            errorRtoList.add(new ErrorRTO("RCA", "Campo non valido"));
        }

        if (!CollectionUtils.isEmpty(errorRtoList)) {
            throw new LicencePlateException(errorRtoList, HttpStatus.BAD_REQUEST);

        }
    }

    public void checkLicencePlateExist(String licence_plate) throws LicencePlateException {
        if (!boatService.licencePlateExist(licence_plate)) {
            throw new LicencePlateException("La targa: " + licence_plate + " non è presente", HttpStatus.NOT_FOUND);
        }
    }
}