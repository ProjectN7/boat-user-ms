package com.Project_N7.boat_management.checkerrors;

import java.util.ArrayList;
import java.util.List;

import com.Project_N7.boat_management.exception.cf_exception;
import com.Project_N7.boat_management.rto.errorRTO;
import com.Project_N7.boat_management.service.user_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

//@Component
@Service
public class check_errors {

    @Autowired
    private user_service user_service;

    public void check_id_list(List<Long> ids) throws cf_exception {

        List<errorRTO> errorRTO_list = new ArrayList<>();
        if (CollectionUtils.isEmpty(ids)) {
            errorRTO_list.add(new errorRTO("Non è stato inserito nessun id per la ricerca!"));
            throw new cf_exception(errorRTO_list, HttpStatus.NOT_FOUND); // Lancio subito poichè voglio che un
            // differente HttpStatus
        }

        for (Long id : ids) {
            errorRTO_list.add(check_if_null(id));
            errorRTO_list.add(checkId(id));
        }

        List<errorRTO> errorRtoListClear = new ArrayList<>();
        for (errorRTO errorRtoTemp : errorRTO_list) {
            if (errorRtoTemp != null) {
                errorRtoListClear.add(errorRtoTemp);
            }
        }

        // Lancio dell'eccezione
        if (!errorRtoListClear.isEmpty()) {
            throw new cf_exception(errorRTO_list, HttpStatus.BAD_REQUEST);
        }
    }

    public errorRTO checkId(Long id) {
        if (!user_service.exists_by_id(id)) {
            return new errorRTO("id: " + id + " non presente");
        }
        return null;
    }

    public errorRTO check_if_null(Long id) {
        if (id == null) {
            return new errorRTO("null inserito nella lista");
        }
        return null;
    }

    public void check_exist_cf(String cf) throws cf_exception {
        List<errorRTO> errorRTO_list = new ArrayList<>();
        if (user_service.cf_exist(cf)) {
            errorRTO_list.add(new errorRTO(
                    "Esiste già una persona con questo codice fiscale"));
        }
        if (!errorRTO_list.isEmpty()) {
            throw new cf_exception(errorRTO_list, HttpStatus.CONFLICT);
        }
    }

}

