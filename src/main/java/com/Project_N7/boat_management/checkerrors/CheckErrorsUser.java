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
    private UserService userService;

    public void checkExistCf(String cf) throws ErrorException {
        ErrorRTO error = new ErrorRTO();
        if (userService.cfExist(cf)) {
            error.setMessage(CF_ALREADY_EXIST);
        }
        if (StringUtils.isNotBlank(error.getMessage())) {
            throw new ErrorException(error.getMessage());
        }
    }

    public void checkInformations(String cf, UserToModifyTO userToModifyTO)
            throws ErrorException, IllegalArgumentException, IllegalAccessException {

        List<ErrorRTO> errorRtoList = new ArrayList<>();

        if (userToModifyTO.getAddress() == null ) {
            errorRtoList.add(new ErrorRTO(ADDRESS, NOT_VALID));
        }

        if (userToModifyTO.getPostalCode() == null) {
            errorRtoList.add(new ErrorRTO(POSTAL_CODE, NOT_VALID));
        }

        if (userToModifyTO.getPhoneNumber() == null) {
            errorRtoList.add(new ErrorRTO(PHONE_NUMBER, NOT_VALID));
        }

        if (userToModifyTO.getBoatLicence() == null) {
            errorRtoList.add(new ErrorRTO(BOAT_LICENCE, NOT_VALID));
        }

        if (userToModifyTO.getEmail() == null) {
            errorRtoList.add(new ErrorRTO(EMAIL, NOT_VALID));
        }

        if (userToModifyTO.getPassword() == null) {
            errorRtoList.add(new ErrorRTO(PASSWORD, NOT_VALID));
        }
    }

}

