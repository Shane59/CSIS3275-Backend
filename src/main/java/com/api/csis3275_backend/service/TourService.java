package com.api.csis3275_backend.service;

import com.api.csis3275_backend.entities.Tour;
import com.api.csis3275_backend.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;

    public Tour createTour(String tourName,
                           String location, BigDecimal duration, BigDecimal price,
                           String description, String imageURL) {
        int latestId = tourRepository.findLatestTourId();
        Tour newTour = new Tour(latestId + 1, tourName, location, duration, price, description, imageURL);
        tourRepository.save(newTour);
        return newTour;
    }
}
