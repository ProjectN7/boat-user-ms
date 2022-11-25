package com.Project_N7.boat_management.repository;

import com.Project_N7.boat_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u " + "FROM User u WHERE cf=u.cf")
    List<User> getUserByCf(String cf);


    @Query(value = "SELECT  u.cf " + "FROM User u " + "WHERE u.cf = ?1")
    String cfExist(String cf);

    @Query("SELECT u FROM User u WHERE u.id_user = ?1")
    User findUserFromId(Long id);

    @Query("SELECT u FROM User u WHERE u.name LIKE ?1 AND u.surname LIKE ?2")
    List<User> findUserFromNameSurname(String nome, String cognome);

    @Query("SELECT u FROM User u WHERE u.cf = ?1")
    User findUserFromCf(String cf);

    @Query("SELECT u FROM User u WHERE u.boat_licence = ?1")
    User findUserFromBoatLicence(String boat_licence);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findUserFromEmail(String email);

}
