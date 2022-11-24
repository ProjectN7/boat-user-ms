package com.Project_N7.boat_management.facade;

import com.Project_N7.boat_management.entity.user;
import com.Project_N7.boat_management.exception.cf_exception;
import com.Project_N7.boat_management.rto.userRTO;
import com.Project_N7.boat_management.service.user_service;

import com.Project_N7.boat_management.to.userTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


@Component
public class user_facade {

    @Autowired
    user_service user_service;

    public List<userRTO> get_user_by_cf(String cf) throws cf_exception {
        if (!user_service.cf_exist(cf)) { // Prima chiamata al server per vedere se il
            // cf esiste
            throw new cf_exception("CF non presente"); // Altrimenti lancio l'eccezione
        }
        // Se il numero è presente vado a cercarmi le persone che lo posseggono
        return user_service.get_user_by_cf(cf);
    }

    public String save_user(userTO userTO) {
        Long id = user_service.save_user(userTO);
        if (id != null) {
            return "Alla persona aggiunta è stato assegnato l'id: " + id;
        }

        return "La persona non è stata inserita";
    }

}
