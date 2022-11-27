package com.Project_N7.boat_management.controller;

import java.util.List;

import com.Project_N7.boat_management.checkerrors.CheckErrorsUser;
import com.Project_N7.boat_management.exception.CfException;
import com.Project_N7.boat_management.facade.UserFacade;
import com.Project_N7.boat_management.rto.UserRTO;
import com.Project_N7.boat_management.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class UserController extends BaseController {

    @Autowired
    private UserFacade user_facade;

    @Autowired
    private CheckErrorsUser errors;

    private UserRTO userRTO;

    //Restituisce una lista, vedi di farti restituire uno solo
    @GetMapping(value = "/user/userList")
    public ResponseEntity<Object> getUserFromCf(@RequestParam String cf) {
        List<UserRTO> userRTOs;
        try {
            userRTOs = user_facade.getUserByCf(cf);
        } catch (CfException e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        if (userRTOs.isEmpty()) {
            return new ResponseEntity<>("Nessuna persona associata al CF", HttpStatus.BAD_REQUEST);
        } else {

            return new ResponseEntity<>(userRTOs,HttpStatus.OK);
        }

    }

    @PostMapping(value = "/user/userSave")
    public ResponseEntity<Object> userSave(@Valid @RequestBody UserTO userTO) {
        try {
            errors.checkExistCf(userTO.getCf());
        } catch (CfException e) {
            return new ResponseEntity<>(e.getErrorRTO_list(), e.getHttp_status());
        }
        return new ResponseEntity<>(user_facade.userSave(userTO), HttpStatus.OK);
    }


}
