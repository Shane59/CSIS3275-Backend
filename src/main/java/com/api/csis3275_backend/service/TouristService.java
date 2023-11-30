package com.api.csis3275_backend.service;

import com.api.csis3275_backend.entities.Tourist;
import com.api.csis3275_backend.repositories.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TouristService {
    @Autowired
    private TouristRepository touristRepository;
    public Tourist createNewTourist(String firstname, String lastname,
                                    String email, String username, String password,
                                    String preference) {
        int latestId = touristRepository.findLatestTouristId();
        Tourist newTourist = new Tourist(latestId + 1, firstname, lastname,
                email, username, password, preference);
        touristRepository.save(newTourist);
        return newTourist;
    }
}
