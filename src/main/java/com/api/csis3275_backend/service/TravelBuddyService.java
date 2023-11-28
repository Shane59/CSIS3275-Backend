package com.api.csis3275_backend.service;

import com.api.csis3275_backend.entities.TravelBuddy;
import com.api.csis3275_backend.repositories.TravelBuddyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelBuddyService {

    @Autowired
    TravelBuddyRepository travelBuddyRepository;

    public TravelBuddy createTravelBuddy( String firstname, String lastname, String username,
                                         String email, String password, String description,
                                         String applicationStatus, String resumeURL, String profileImageURL, float averageStarRate) {

        TravelBuddy newTravelBuddy = new TravelBuddy( firstname, lastname, username, email, password, description, applicationStatus, resumeURL, profileImageURL, averageStarRate);

        travelBuddyRepository.save(newTravelBuddy);
        return newTravelBuddy;
    }

}

