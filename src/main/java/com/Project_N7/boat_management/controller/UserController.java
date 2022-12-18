package com.Project_N7.boat_management.controller;

import java.util.List;

import com.Project_N7.boat_management.checkerrors.CheckErrorsUser;
import com.Project_N7.boat_management.exception.CfException;
import com.Project_N7.boat_management.facade.UserFacade;
import com.Project_N7.boat_management.model.JwtRequest;
import com.Project_N7.boat_management.model.Jwtresponse;
import com.Project_N7.boat_management.rto.UserRTO;
import com.Project_N7.boat_management.service.UserService;
import com.Project_N7.boat_management.to.UserTO;
import com.Project_N7.boat_management.to.UserToModifyTO;
import com.Project_N7.boat_management.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class UserController extends BaseController {

    @Autowired
    private UserFacade user_facade;

    @Autowired
    private CheckErrorsUser errors;

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

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

            return new ResponseEntity<>(userRTOs, HttpStatus.OK);
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

    @CrossOrigin
    @PostMapping(path = "/modificaUser/{cf}")
    public ResponseEntity<Object> modificaUser(@Valid @PathVariable("cf") String cf,
                                               @Valid @RequestBody UserToModifyTO userToModifyTO) {
        try {
            errors.checkInformations(cf, userToModifyTO);
        } catch (CfException e) {
            return new ResponseEntity<>(e.getErrorRTO_list(), e.getHttp_status());
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(user_facade.modificaUser(cf, userToModifyTO), HttpStatus.OK);
    }


    //Metodo per autenticare prendendo in input email e password
    //
    @PostMapping("/user/authenticate")
    public Jwtresponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        //Ogni volta che viene passato un jwtRequest verrà generato il token
        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getEmail());
        final String token = jwtUtility.generateToken(userDetails);

        return new Jwtresponse(token);

    }

    //Test per vedere se l'autenticazione funzioni oppure no
    //Il test funziona se e solo se prima l'autenticazione funziona
    @GetMapping("/")
    public String home() {
        return "Test";
    }
}
