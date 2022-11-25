package com.Project_N7.boat_management.controller;

import java.util.List;

import com.Project_N7.boat_management.checkerrors.check_errors;
import com.Project_N7.boat_management.exception.cf_exception;
import com.Project_N7.boat_management.facade.user_facade;
import com.Project_N7.boat_management.rto.userRTO;
import com.Project_N7.boat_management.to.userTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class user_controller extends base_controller{

    //@Autowired
    private user_facade user_facade;

    //@Autowired
    private check_errors errors;

    @GetMapping(value = "/user/user_list")
    public ResponseEntity<Object> get_user_from_cf(@RequestParam String cf) {
        List<userRTO> userRTOs;
        try {
            userRTOs = user_facade.get_user_by_cf(cf);
        } catch (cf_exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        // Sicuramente potevo evitarmi l'if, devo imparare a lanciare eccezzioni di
        // diverso tipo in base al caso
        if (userRTOs.isEmpty()) {
            return new ResponseEntity<>("Nessuna persona associata al numero di telefono", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(userRTOs, HttpStatus.OK);
        }

    }

    @PostMapping(value = "/boat_management/user/save_user")
    public ResponseEntity<Object> save_user(@Valid @RequestBody userTO userTO) {
        try {
            errors.check_exist_cf(userTO.getCf());
        } catch (cf_exception e) {
            return new ResponseEntity<>(e.getErrorRTO_list(), e.getHttp_status());
        }
        return new ResponseEntity<>(user_facade.save_user(userTO), HttpStatus.OK);
    }

}
