package com.Project_N7.boat_management.checkerrors;

import java.util.ArrayList;
import java.util.List;

import com.Project_N7.boat_management.exception.ErrorException;
import com.Project_N7.boat_management.rto.ErrorRTO;
import com.Project_N7.boat_management.service.UserService;
import com.Project_N7.boat_management.to.UserToModifyTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import static com.Project_N7.boat_management.constants.Constants.*;

//@Component
@Service
public class CheckErrorsUser {

    @Autowired
    private UserService user_service;

    public void checkExistCf(String cf) throws ErrorException {
        ErrorRTO error = new ErrorRTO();
        if (user_service.cfExist(cf)) {
            error.setMessage(CF_ALREADY_EXIST);
        }
        if (StringUtils.isNotBlank(error.getMessage())) {
            throw new ErrorException(error.getMessage());
        }
    }

    public void checkInformations(String cf, UserToModifyTO userToModifyTO)
            throws ErrorException, IllegalArgumentException, IllegalAccessException {

        checkCfExist(cf);
        List<ErrorRTO> errorRtoList = new ArrayList<>();

        if (userToModifyTO.getAddress() == null ) {
            errorRtoList.add(new ErrorRTO("Address", "Campo non valido"));
        }

        if (userToModifyTO.getPostalCode() != null && !userToModifyTO.getPostalCode().matches("^[0-9]{5}$")) {
            errorRtoList.add(new ErrorRTO("Postal Code", "Campo non valido"));
        }

        if (userToModifyTO.getPhoneNumber() != null && !userToModifyTO.getPhoneNumber().matches("^[0-9]{10}$")) {
            errorRtoList.add(new ErrorRTO("Phone number", "Campo non valido"));
        }

        if (userToModifyTO.getBoatLicence() != null && !userToModifyTO.getBoatLicence().matches("^[A-Z]{2}[0-9]{6}$")) {
            errorRtoList.add(new ErrorRTO("Boat Licence", "Campo non valido"));
        }

        if (userToModifyTO.getEmail()!= null && !userToModifyTO.getEmail().matches("[a-zA-Z0-9.]+@[a-zA-Z]+[.][a-zA-Z]+")) {
            errorRtoList.add(new ErrorRTO("Email", "Campo non valido"));
        }

        if (userToModifyTO.getPassword() == null) {
            errorRtoList.add(new ErrorRTO("Password", "Campo non valido"));
        }

        if (!CollectionUtils.isEmpty(errorRtoList)) {
            throw new ErrorException(errorRtoList);

        }
    }

    public void checkCfExist(String cf) throws ErrorException {
        if (!user_service.cfExist(cf)) {
            throw new ErrorException(CF +cf + NOT_EXIST);
        }
    }

}

