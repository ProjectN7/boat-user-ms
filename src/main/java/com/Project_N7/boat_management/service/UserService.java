package com.Project_N7.boat_management.service;

import java.util.ArrayList;
import java.util.List;

import com.Project_N7.boat_management.entity.User;
import com.Project_N7.boat_management.repository.UserRepository;
import com.Project_N7.boat_management.rto.UserCompletoRTO;
import com.Project_N7.boat_management.rto.UserRTO;
import com.Project_N7.boat_management.to.UserTO;
import com.Project_N7.boat_management.to.UserToModifyTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserRTO> getUserByCf(String cf) {

        // Chiamo il metodo trasferisciDaPersonaAPersonaRto per popolarla con i dati che
        // mi servono
        return convertUserTO_UserRTO(userRepository.getUserByCf(cf));
    }
    public boolean cfExist(String cf) {
        return (userRepository.findUserFromCf(cf) != null);
    }

    public String userSave(UserTO userTO) {
        User user_to_save = new User();
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
        return userRepository.save(user_to_save).getCf();
        //return user_repository.save(user_to_save).getCf();
    }

    private List<UserRTO> convertUserTO_UserRTO(List<User> user_list) {

        // Creo la lista di PersonaRTO
        List<UserRTO> personaRtoList = new ArrayList<>();
        // Ciclo for per passare una ad una le persone dall'entità completa
        // all'oggetto custom RTO contenente solo le informazioni che vogliamo
        for (User user : user_list) {

            // Creazione della PersonaRTO temporanea
            UserRTO userRTO_temp = populateUserRTO(user);

            // Inserimento della PersonaRTO temporanea in nella lista di personeRto
            personaRtoList.add(userRTO_temp);
        }
        return personaRtoList;
    }


    private UserRTO populateUserRTO(User user) {
        UserRTO userRTO_temp = new UserRTO();

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



    public UserCompletoRTO modificaUser(String cf, UserToModifyTO userToModifyTO){
        User userTemp = userRepository.getById(cf);
        cambiaNotNull(userTemp, userToModifyTO);
        return convertUserToUserCompletoRTO(userRepository.save(userTemp));
    }



    public void cambiaNotNull(User userTemp, UserToModifyTO userToModifyTO){
        userTemp.setAddress(userToModifyTO.getAddress() != null ? userToModifyTO.getAddress() : userTemp.getAddress());
        userTemp.setBoat_licence(userToModifyTO.getBoat_licence() != null ? userToModifyTO.getBoat_licence() : userTemp.getBoat_licence());
        userTemp.setEmail(userToModifyTO.getEmail() != null ? userToModifyTO.getEmail() : userTemp.getEmail());
        userTemp.setPassword(userToModifyTO.getPassword() != null ? userToModifyTO.getPassword() : userTemp.getPassword());
        userTemp.setPostal_code(userToModifyTO.getPostal_code() != null ? userToModifyTO.getPostal_code() : userTemp.getPostal_code());
        userTemp.setPhone_number(userToModifyTO.getPhone_number() != null ? userToModifyTO.getPhone_number() : userTemp.getPhone_number());

    }

    private UserCompletoRTO convertUserToUserCompletoRTO(User user){
        UserCompletoRTO userCompletoRTOtemp = new UserCompletoRTO();

        userCompletoRTOtemp.setCf(user.getCf());
        userCompletoRTOtemp.setName(user.getName());
        userCompletoRTOtemp.setSurname(user.getSurname());
        userCompletoRTOtemp.setDate_of_birth(user.getDate_of_birth());
        userCompletoRTOtemp.setGender(user.getGender());
        userCompletoRTOtemp.setNationality(user.getNationality());
        userCompletoRTOtemp.setAddress(user.getAddress());
        userCompletoRTOtemp.setPostal_code(user.getPostal_code());
        userCompletoRTOtemp.setPhone_number(user.getPhone_number());
        userCompletoRTOtemp.setBoat_licence(user.getBoat_licence());
        userCompletoRTOtemp.setEmail(user.getEmail());
        userCompletoRTOtemp.setPassword(user.getPassword());
        userCompletoRTOtemp.setIs_admin(user.isIs_admin());
        return userCompletoRTOtemp;

    }
}
