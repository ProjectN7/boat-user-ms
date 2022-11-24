package com.Project_N7.boat_management.repository;

import com.Project_N7.boat_management.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface user_repository extends JpaRepository<user, Long> {

    @Query("SELECT u " + "FROM user u WHERE cf=u.cf")
    List<user> get_user_by_cf(String cf);


    @Query(value = "SELECT  u.cf " + "FROM user u " + "WHERE u.cf = ?1")
    String cf_exist(String cf);

    @Query("SELECT u FROM user u WHERE u.id_user = ?1")
    user find_user_from_id(Long id);

    @Query("SELECT u FROM user u WHERE u.name LIKE ?1 AND u.surname LIKE ?2")
    List<user> find_user_from_nome_Cognome(String nome, String cognome);

    @Query("SELECT u FROM user u WHERE u.cf = ?1")
    user find_user_from_cf(String cf);

    @Query("SELECT u FROM user u WHERE u.boat_licence = ?1")
    user find_user_from_boat_licence(String boat_licence);

    @Query("SELECT u FROM user u WHERE u.email = ?1")
    user find_user_from_email(String email);

}
