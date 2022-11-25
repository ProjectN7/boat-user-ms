package com.Project_N7.boat_management.facade;

import com.Project_N7.boat_management.exception.CfException;
import com.Project_N7.boat_management.rto.UserRTO;
import com.Project_N7.boat_management.service.UserService;

import com.Project_N7.boat_management.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//@Component
@Service
public class UserFacade {
    @Autowired
    UserService user_service;

    public List<UserRTO> getUserByCf(String cf) throws CfException {
        if (!user_service.cfExist(cf)) { // Prima chiamata al server per vedere se il
            // cf esiste
            throw new CfException("CF non presente"); // Altrimenti lancio l'eccezione
        }
        // Se il numero è presente vado a cercarmi le persone che lo posseggono
        return user_service.getUserByCf(cf);
    }

    public String userSave(UserTO userTO) {
        Long id = user_service.userSave(userTO);
        if (id != null) {
            return "Alla persona aggiunta è stato assegnato l'id: " + id;
        }

        return "La persona non è stata inserita";
    }

}
