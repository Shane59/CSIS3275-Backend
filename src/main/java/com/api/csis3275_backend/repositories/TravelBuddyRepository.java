package com.api.csis3275_backend.repositories;

import com.api.csis3275_backend.entities.TravelBuddy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface TravelBuddyRepository extends JpaRepository<TravelBuddy, Long> {
    @Query(value = "SELECT * FROM TravelBuddy WHERE applicationStatus = :applicationStatus", nativeQuery = true)
    List<TravelBuddy> findByApplicationStatus(String applicationStatus);

    @Query(value = "SELECT * FROM TravelBuddy  WHERE travelBuddyID = :travelBuddyID", nativeQuery = true)
    List<TravelBuddy> findByTravelBuddyID(int travelBuddyID);

    @Query(value = "SELECT DISTINCT t.travelBuddyID, t.firstName, t.lastName," +
            "t.email, t.description, t.username, t.password, t.resumeURL, t.profileImageURL," +
            "t.applicationStatus, t.averageStarRate FROM availability a, travelbuddy t where t.travelbuddyid=a.travelbuddyId", nativeQuery = true)
    List<TravelBuddy> findByTourID(int tourID);

    @Override
    TravelBuddy save(TravelBuddy travelBuddy);
}
