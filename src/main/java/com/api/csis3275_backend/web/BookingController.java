package com.api.csis3275_backend.web;

import com.api.csis3275_backend.entities.Booking;
import com.api.csis3275_backend.repositories.BookingRepository;
import com.api.csis3275_backend.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    BookingService bookingService;

    @GetMapping("/api/booking")
    public List<Booking> booking(Model model, @RequestParam(name="travelBuddyID", defaultValue = "") String travelBuddyID,
                                 @RequestParam(name = "touristID", defaultValue = "") String touristID) {
        if (travelBuddyID.isEmpty() && touristID.isEmpty()) {
            return bookingRepository.findAll();
        }
        long id;
        if (!travelBuddyID.isEmpty()) {
            id = Long.parseLong(travelBuddyID);
            return bookingRepository.findByTravelBuddyID(id);
        }
        id = Long.parseLong(touristID);
        return bookingRepository.findByTouristID(id);
    }


    @PostMapping("/api/booking/create")
    public ResponseEntity<Booking> createBooking(@RequestParam(name = "touristID") int touristID,
                                                @RequestParam(name = "travelBuddyID") int travelBuddyID,
                                                @RequestParam(name = "tourID") int tourID) {

        Booking newBooking = bookingService.createNewBooking(touristID, travelBuddyID, tourID);
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }
}
