package com.Project_N7.boat_management.service;

import java.util.ArrayList;
import java.util.List;

import com.Project_N7.boat_management.entity.user;
import com.Project_N7.boat_management.repository.user_repository;
import com.Project_N7.boat_management.rto.userRTO;
import com.Project_N7.boat_management.to.userTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class user_service {

    @Autowired
    private user_repository user_repository;

    public List<userRTO> get_user_by_cf(String cf) {

        // Chiamo il metodo trasferisciDaPersonaAPersonaRto per popolarla con i dati che
        // mi servono
        return convert_userTO_userRTO(user_repository.get_user_by_cf(cf));
    }
    public boolean cf_exist(String cf) {
        return (user_repository.find_user_from_cf(cf) != null);
    }

    public Long save_user(userTO userTO) {
        user user_to_save = new user();
        user_to_save.setCf(userTO.getCf());
        user_to_save.setName(userTO.getName());
        user_to_save.setSurname(userTO.getSurname());
        user_to_save.setDate_of_birth(userTO.getDate_of_birth());
        user_to_save.setAddress(userTO.getAddress());
        user_to_save.setGender(userTO.getGender());
        user_to_save.setNationality(userTO.getNationality());
        user_to_save.setPostal_code(userTO.getPostal_code());
        user_to_save.setPhone_number(userTO.getPhone_number());
        user_to_save.setBoat_licence(userTO.getBoat_licence());
        user_to_save.setEmail(userTO.getEmail());
        user_to_save.setPassword(userTO.getPassword());
        return user_repository.save(user_to_save).getId_user();
    }

    private List<userRTO> convert_userTO_userRTO(List<user> user_list) {

        // Creo la lista di PersonaRTO
        List<userRTO> personaRtoList = new ArrayList<>();
        // Ciclo for per passare una ad una le persone dall'entità completa
        // all'oggetto custom RTO contenente solo le informazioni che vogliamo
        for (user user : user_list) {

            // Creazione della PersonaRTO temporanea
            userRTO userRTO_temp = populate_userRTO(user);

            // Inserimento della PersonaRTO temporanea in nella lista di personeRto
            personaRtoList.add(userRTO_temp);
        }
        return personaRtoList;
    }


    private userRTO populate_userRTO(user user) {
        userRTO userRTO_temp = new userRTO();

        // Popolamento tramite setter e getter
        userRTO_temp.setCf(user.getCf());
        userRTO_temp.setName(user.getName());
        userRTO_temp.setSurname(user.getSurname());
        userRTO_temp.setDate_of_birth(user.getDate_of_birth());
        userRTO_temp.setAddress(user.getAddress());
        userRTO_temp.setGender(user.getGender());
        userRTO_temp.setNationality(user.getNationality());
        userRTO_temp.setPostal_code(user.getPostal_code());
        userRTO_temp.setPhone_number(user.getPhone_number());
        userRTO_temp.setBoat_licence(user.getBoat_licence());
        userRTO_temp.setEmail(user.getEmail());
        userRTO_temp.setPassword(user.getPassword());
        return userRTO_temp;
    }

    public boolean exists_by_id(Long id) {
        return (user_repository.find_user_from_id(id) != null);
    }

}
