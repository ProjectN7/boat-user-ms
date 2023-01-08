package com.Project_N7.boat_management.controller;

import java.util.List;

import com.Project_N7.boat_management.checkerrors.CheckErrorsUser;
import com.Project_N7.boat_management.entity.User;
import com.Project_N7.boat_management.exception.ErrorException;
import com.Project_N7.boat_management.facade.UserFacade;
import com.Project_N7.boat_management.model.JwtRequest;
import com.Project_N7.boat_management.model.Jwtresponse;
import com.Project_N7.boat_management.model.ServiceResponse;
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

import static com.Project_N7.boat_management.constants.Constants.*;


@RestController
public class UserController extends BaseController {

    @Autowired
    private UserFacade userFacade;

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

    /*
    @GetMapping(value = "/user/userList")
    public ResponseEntity<Object> getUserFromCf(@RequestParam String cf) {
        UserRTO userRTOs;
        try {
            userRTOs = userFacade.getUserByCf(cf);
        } catch (ErrorException e) {

            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, e.getMessage(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), CF_FOUND, CF_FOUND, userRTOs), HttpStatus.OK);
    }
    */


    @GetMapping(value = "/user/getUserByCf")
    public ResponseEntity<Object> getUserByCf(@RequestParam String cf) {
        User user;
        try {
            user = userFacade.getUserByCf(cf);
        } catch (ErrorException e) {

            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, e.getMessage(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
        System.out.println(user);

        return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), CF_FOUND, CF_FOUND, user), HttpStatus.OK);

    }


    @GetMapping(value = "/user/getCfByEmail")
    public ResponseEntity<Object> getCfByEmail(@RequestParam String email) {
        String cf;
        try {
            cf = userFacade.getCfByEmail(email);
        } catch (ErrorException e) {

            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, e.getMessage(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), CF_FOUND, CF_FOUND, cf), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/user/userSave")
    public ResponseEntity<Object> userSave(@Valid @RequestBody UserTO userTO) {
        try {
            errors.checkExistCf(userTO.getCf());
        } catch (ErrorException e) {
            return new ResponseEntity<>(new ServiceResponse(CODE_409, HttpStatus.CONFLICT.name(), EXCEPTION, e.getMessage(), e.getMessage()), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), CF_FOUND, CF_FOUND, userFacade.userSave(userTO)), HttpStatus.OK);
    }


    @PostMapping(path = "/user/modificaUser/{cf}")
    public ResponseEntity<Object> modificaUser(@Valid @PathVariable("cf") String cf,
                                               @Valid @RequestBody UserToModifyTO userToModifyTO) {
        try {
            errors.checkInformations(cf, userToModifyTO);
        } catch (ErrorException e) {
            return new ResponseEntity<>(new ServiceResponse(CODE_400, HttpStatus.BAD_REQUEST.name(), EXCEPTION, e.getMessage(), e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new ServiceResponse(CODE_500, HttpStatus.INTERNAL_SERVER_ERROR.name(), EXCEPTION, e.getMessage(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), CF_FOUND, CF_FOUND, userFacade.modificaUser(cf, userToModifyTO)), HttpStatus.OK);
    }


    //Metodo per autenticare prendendo in input email e password

    @PostMapping("/user/authenticate")
    public Jwtresponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception(INVALID_CREDENTIALS, e);
        }
        //Ogni volta che viene passato un jwtRequest verrà generato il token
        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getEmail());
        final String token = jwtUtility.generateToken(userDetails);

        return new Jwtresponse(token);

    }

    @GetMapping(path = "/user/userDelete")
    public ResponseEntity<Object> deleteUser(@RequestParam String cf){
        try {
            errors.checkExistCf(cf);
        } catch (ErrorException e) {
            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, e.getMessage(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), CF_FOUND, CF_FOUND, userFacade.deleteUserByCf(cf)), HttpStatus.OK);
    }

    //Test per vedere se l'autenticazione funzioni oppure no
    //Il test funziona se e solo se prima l'autenticazione funziona
    @GetMapping("/")
    public String home() {
        return "Test";
    }
}
