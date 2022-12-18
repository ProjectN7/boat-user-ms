package com.Project_N7.boat_management.repository;

import com.Project_N7.boat_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u " + "FROM User u WHERE cf=u.cf")
    List<User> getUserByCf(String cf);


    @Query(value = "SELECT  u.cf " + "FROM User u " + "WHERE u.cf = ?1")
    String cfExist(String cf);

    @Query("SELECT u FROM User u WHERE u.name LIKE ?1 AND u.surname LIKE ?2")
    List<User> findUserFromNameSurname(String name, String surname);

    @Query("SELECT u FROM User u WHERE u.cf = ?1")
    User findUserFromCf(String cf);

    @Query("SELECT u FROM User u WHERE u.boat_licence = ?1")
    User findUserFromBoatLicence(String boat_licence);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findUserFromEmail(String email);

    @Query("SELECT password FROM User WHERE email = ?1")
    String getPasswordFromEmail(String email);

    @Query("SELECT email FROM User Where email = ?1")
    String getEmailFromEmail(String email);

}
