package com.Project_N7.boat_management.repository;

import com.Project_N7.boat_management.entity.Boat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoatRepository extends JpaRepository<Boat, String> {

    @Query("SELECT b " + "FROM Boat b WHERE licence_plate=b.licence_plate")
    List<Boat> getBoatByLicencePlate(String licence_plate);


    @Query(value = "SELECT  b.licence_plate " + "FROM Boat b " + "WHERE b.licence_plate = ?1")
    String licencePlateExist(String licence_plate);

    @Query("SELECT b FROM Boat b WHERE b.licence_plate = ?1")
    Boat findBoatFromLicencePlate(String licence_plate);

}
