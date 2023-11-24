package com.api.csis3275_backend.web;

import com.api.csis3275_backend.entities.Administrator;
import com.api.csis3275_backend.entities.Tour;
import com.api.csis3275_backend.repositories.AdminRepository;
import com.api.csis3275_backend.repositories.TourRepository;
import com.api.csis3275_backend.service.TourService;
import com.api.csis3275_backend.repositories.TravelBuddyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
public class AdminController {

    @Autowired
    AdminRepository adminRepository;
    TourRepository tourRepository;
    TravelBuddyRepository travelBuddyRepository;
    TourService tourService;

    @GetMapping("/api/admin")
    public List<Administrator> admin(Model model, @RequestParam(name="id", defaultValue = "") String id) {
        if (id.isEmpty()) {
            return adminRepository.findAll();
        }
        long key = Long.parseLong(id);
        return adminRepository.findByAdminId(key);
    }

    @PostMapping("/api/admin/tours/addTour")
    public ResponseEntity<Tour> createTour(@RequestBody Tour tour) {
        Tour newTour = tourService.createTour(tour.getTourName(), tour.getLocation(), tour.getDuration(), tour.getPrice(), tour.getDescription(), tour.getImageURL());

        return new ResponseEntity<>(newTour, HttpStatus.CREATED);

    }

    @GetMapping("/api/admin/tours")
    public List<Tour> displayAllTours() {
        return tourRepository.findAll();
    }

    @DeleteMapping("/api/admin/tours/delete/{tourID}")
    public ResponseEntity<?> deleteTour(@PathVariable long tourID) {
        tourRepository.deleteById(tourID);

        return new ResponseEntity<>(tourID, HttpStatus.OK);
    }
}
