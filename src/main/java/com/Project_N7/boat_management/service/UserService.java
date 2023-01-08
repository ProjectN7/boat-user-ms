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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//è stato aggiunto implements UserDetailsService per poter utilizzare il metodo loadUserByUsername
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

/*
    public UserRTO getUserByCf(String cf) {

        // Chiamo il metodo trasferisciDaPersonaAPersonaRto per popolarla con i dati che
        // mi servono
        return populateUserRTO(userRepository.getUserByCf(cf));
    }


 */
    public boolean cfExist(String cf) {
        return (userRepository.findUserFromCf(cf) != null);
    }




    public String userSave(UserTO userTO) {
        User user_to_save = new User();
        user_to_save.setCf(userTO.getCf());
        user_to_save.setName(userTO.getName());
        user_to_save.setSurname(userTO.getSurname());
        user_to_save.setDateOfBirth(userTO.getDateOfBirth());
        user_to_save.setAddress(userTO.getAddress());
        user_to_save.setGender(userTO.getGender());
        user_to_save.setNationality(userTO.getNationality());
        user_to_save.setPostalCode(userTO.getPostalCode());
        user_to_save.setPhoneNumber(userTO.getPhoneNumber());
        user_to_save.setBoatLicence(userTO.getBoatLicence());
        user_to_save.setEmail(userTO.getEmail());
        user_to_save.setPassword(userTO.getPassword());
        return userRepository.save(user_to_save).getCf();
        //return user_repository.save(user_to_save).getCf();
    }

    private List<UserRTO> convertUserTO_UserRTO(List<User> userList) {

        // Creo la lista di PersonaRTO
        List<UserRTO> personaRtoList = new ArrayList<>();
        // Ciclo for per passare una ad una le persone dall'entità completa
        // all'oggetto custom RTO contenente solo le informazioni che vogliamo
        for (User user : userList) {

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
        userRTO_temp.setDateOfBirth(user.getDateOfBirth());
        userRTO_temp.setAddress(user.getAddress());
        userRTO_temp.setGender(user.getGender());
        userRTO_temp.setNationality(user.getNationality());
        userRTO_temp.setPostalCode(user.getPostalCode());
        userRTO_temp.setPhoneNumber(user.getPhoneNumber());
        userRTO_temp.setBoatLicence(user.getBoatLicence());
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
        userTemp.setBoatLicence(userToModifyTO.getBoatLicence() != null ? userToModifyTO.getBoatLicence() : userTemp.getBoatLicence());
        userTemp.setEmail(userToModifyTO.getEmail() != null ? userToModifyTO.getEmail() : userTemp.getEmail());
        userTemp.setPassword(userToModifyTO.getPassword() != null ? userToModifyTO.getPassword() : userTemp.getPassword());
        userTemp.setPostalCode(userToModifyTO.getPostalCode() != null ? userToModifyTO.getPostalCode() : userTemp.getPostalCode());
        userTemp.setPhoneNumber(userToModifyTO.getPhoneNumber() != null ? userToModifyTO.getPhoneNumber() : userTemp.getPhoneNumber());

    }

    private UserCompletoRTO convertUserToUserCompletoRTO(User user){
        UserCompletoRTO userCompletoRTOtemp = new UserCompletoRTO();

        userCompletoRTOtemp.setCf(user.getCf());
        userCompletoRTOtemp.setName(user.getName());
        userCompletoRTOtemp.setSurname(user.getSurname());
        userCompletoRTOtemp.setDateOfBirth(user.getDateOfBirth());
        userCompletoRTOtemp.setGender(user.getGender());
        userCompletoRTOtemp.setNationality(user.getNationality());
        userCompletoRTOtemp.setAddress(user.getAddress());
        userCompletoRTOtemp.setPostalCode(user.getPostalCode());
        userCompletoRTOtemp.setPhoneNumber(user.getPhoneNumber());
        userCompletoRTOtemp.setBoatLicence(user.getBoatLicence());
        userCompletoRTOtemp.setEmail(user.getEmail());
        userCompletoRTOtemp.setPassword(user.getPassword());
        userCompletoRTOtemp.setAdmin(user.isAdmin());
        return userCompletoRTOtemp;

    }

    //loadUserByUsername è built-in
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{

        //Logica per prendere lo user da DB
        //Si utilizza User di SpringSecurity
        return new org.springframework.security.core.userdetails.User(userRepository.getEmailFromEmail(email),
                userRepository.getPasswordFromEmail(email), new ArrayList<>());
    }

    public void deleteUserByCf(String cf) { userRepository.deleteUserByCf(cf); }

    public User getUserByCf(String cf) { return userRepository.getUserByCf(cf); }
    public String getCfByEmail(String email) { return userRepository.getCfByEmail(email); }


}
