package com.Project_N7.boat_management.checkerrors;

import java.util.ArrayList;
import java.util.List;

import com.Project_N7.boat_management.exception.CfException;
import com.Project_N7.boat_management.rto.ErrorRTO;
import com.Project_N7.boat_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

//@Component
@Service
public class CheckErrorsUser {

    @Autowired
    private UserService user_service;

    public void checkIdList(List<Long> ids) throws CfException {

        List<ErrorRTO> errorRTO_list = new ArrayList<>();
        if (CollectionUtils.isEmpty(ids)) {
            errorRTO_list.add(new ErrorRTO("Non è stato inserito nessun id per la ricerca!"));
            throw new CfException(errorRTO_list, HttpStatus.NOT_FOUND); // Lancio subito poichè voglio che un
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
            throw new CfException(errorRTO_list, HttpStatus.BAD_REQUEST);
        }
    }


    public ErrorRTO checkIfNull(Long id) {
        if (id == null) {
            return new ErrorRTO("null inserito nella lista");
        }
        return null;
    }

    public void checkExistCf(String cf) throws CfException {
        List<ErrorRTO> errorRTO_list = new ArrayList<>();
        if (user_service.cfExist(cf)) {
            errorRTO_list.add(new ErrorRTO(
                    "Esiste già una persona con questo codice fiscale"));
        }
        if (!errorRTO_list.isEmpty()) {
            throw new CfException(errorRTO_list, HttpStatus.CONFLICT);
        }
    }

}

