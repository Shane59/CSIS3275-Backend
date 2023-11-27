package com.api.csis3275_backend.web;

import com.api.csis3275_backend.entities.TravelBuddy;
import com.api.csis3275_backend.repositories.TravelBuddyRepository;
import com.api.csis3275_backend.service.TravelBuddyService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
public class TravelBuddyController {
     TravelBuddyRepository travelBuddyRepository;
     TravelBuddyService travelBuddyService;


     @GetMapping(path = "/api/admin/travelBuddies")
     public List<TravelBuddy> displayTravelBuddies () {
         return travelBuddyRepository.findAll();
     }


    @GetMapping(path = "/api/travelBuddy/{travelBuddyID}")
    public Optional<TravelBuddy> displayTravelBuddy(@PathVariable int travelBuddyID) {

         return travelBuddyRepository.findByTravelBuddyID(travelBuddyID);

    }

    @GetMapping(path = "/api/admin/travelBuddies/{applicationStatus}")
    public List<TravelBuddy> travelBuddies(@PathVariable String applicationStatus) {

        return travelBuddyRepository.findByApplicationStatus(applicationStatus);
    }

    @PostMapping(path = "/api/signUp/travelBuddy")
    public ResponseEntity<?> signUpTravelBuddy(@RequestBody TravelBuddy travelBuddy ) {

        TravelBuddy newTravelBuddy = travelBuddyService.createTravelBuddy( travelBuddy.getFirstName(), travelBuddy.getLastName(), travelBuddy.getEmail(), travelBuddy.getDescription(), travelBuddy.getUsername(), travelBuddy.getPassword(), travelBuddy.getApplicationStatus(),travelBuddy.getResumeURL(), travelBuddy.getProfileImageURL(), travelBuddy.getAverageStarRate());

        return new ResponseEntity<>(newTravelBuddy, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/api/admin/travelBuddies/pending/delete/{travelBuddyID}")
    public ResponseEntity<?> deletePendingTravelBuddy(@PathVariable long travelBuddyID) {
        travelBuddyRepository.deleteById(travelBuddyID);

        return new ResponseEntity<>(travelBuddyID, HttpStatus.OK);
    }

    @DeleteMapping(path = "/api/admin/travelBuddies/approved/delete/{travelBuddyID}")
    public ResponseEntity<?> deleteApprovedTravelBuddy(@PathVariable long travelBuddyID) {
        travelBuddyRepository.deleteById(travelBuddyID);

        return new ResponseEntity<>(travelBuddyID, HttpStatus.OK);
    }
}
