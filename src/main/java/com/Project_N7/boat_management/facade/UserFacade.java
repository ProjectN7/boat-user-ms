package com.Project_N7.boat_management.facade;

import com.Project_N7.boat_management.entity.User;
import com.Project_N7.boat_management.exception.ErrorException;
import com.Project_N7.boat_management.rto.UserRTO;
import com.Project_N7.boat_management.service.UserService;

import com.Project_N7.boat_management.to.UserTO;
import com.Project_N7.boat_management.to.UserToModifyTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.Project_N7.boat_management.constants.Constants.*;


//@Component
@Service
public class UserFacade {
    @Autowired
    UserService userService;


    /*
    public UserRTO getUserByCf(String cf) throws ErrorException {
        if (!userService.cfExist(cf)) { // Prima chiamata al server per vedere se il
            // cf esiste
            throw new ErrorException(CF_NOT_FOUND); // Altrimenti lancio l'eccezione
        }
        // Se il numero è presente vado a cercarmi le persone che lo posseggono
        return userService.getUserByCf(cf);
    }
    */


    public String userSave(UserTO userTO) {
        String cf = userService.userSave(userTO);
        String resp = "";
        if (cf != null) {
            resp = USER_MADE;
        } else {
            resp = USER_NOT_MADE;
        }

        return resp;
    }

    public Object modificaUser(String cf, UserToModifyTO userToModifyTO){
        userService.modificaUser(cf, userToModifyTO);
        return CHANGE_MADE;
    }

    public User getUserByCf(String cf) throws ErrorException {
        return userService.getUserByCf(cf);
    }

    @Transactional
    public Object deleteUserByCf (String cf) {
        if (cf != null){
            userService.deleteUserByCf(cf);
            return USER_CANCELLED;
        }
        return USER_NOT_CANCELLED;
    }

    public String getCfByEmail(String email) throws ErrorException { return userService.getCfByEmail(email); }

}
