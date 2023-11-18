package com.api.csis3275_backend.web;

import com.api.csis3275_backend.entities.Tour;
import com.api.csis3275_backend.repositories.TourRepository;
import com.api.csis3275_backend.service.TourService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
public class TourController {
    @Autowired
    TourRepository tourRepository;
    @Autowired
    TourService tourService;

    // assume you can only input one search value
    @GetMapping(path = "/api/tours")
    public List<Tour> tours(Model model, @RequestParam(name="id", defaultValue = "") String id,
                            @RequestParam(name="name", defaultValue = "") String name,
                            @RequestParam(name="location", defaultValue = "") String location) {
        if (id.isEmpty() && name.isEmpty() && location.isEmpty()) {
            return tourRepository.findAll();
        }
        if (!id.isEmpty()) {
            long key = Long.parseLong(id);
            return tourRepository.findByTourID(key);
        } else if (!name.isEmpty()) {
            return tourRepository.findByTourNameLike("%" + name + "%");
        }
        return tourRepository.findByLocationLike("%" + location + "%");
    }

    @PostMapping("/api/tours/create")
    public ResponseEntity<Tour> createTour(@RequestParam(name="tourName") String tourName,
                                           @RequestParam(name = "location") String location,
                                           @RequestParam(name = "duration") BigDecimal duration,
                                           @RequestParam(name = "price") BigDecimal price,
                                           @RequestParam(name = "description") String description,
                                           @RequestParam(name = "imageURL") String imageURL) {
        Tour newTour = tourService.createTour(tourName, location, duration, price, description, imageURL);

        return new ResponseEntity<>(newTour, HttpStatus.CREATED);
    }
}
