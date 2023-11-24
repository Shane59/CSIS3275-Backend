package com.api.csis3275_backend.service;

import com.api.csis3275_backend.entities.Booking;
import com.api.csis3275_backend.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    public Booking createNewBooking(int touristID, int travelBuddyID, int tourID) {
        int latestId = bookingRepository.findLatestBookingId();
        Date currentDate = new Date();
        Booking newBooking = new Booking(latestId + 1, touristID, travelBuddyID, tourID, new java.sql.Date(currentDate.getTime()), "");
        bookingRepository.save(newBooking);
        return newBooking;
    }
}
