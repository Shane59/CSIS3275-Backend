package com.api.csis3275_backend.repositories;

import com.api.csis3275_backend.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNullApi;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAll();
    List<Booking> findByTravelBuddyID(long id);

    List<Booking> findByTouristID(long id);

    Booking save(Booking booking);

    @Query("SELECT MAX(b.bookingID) FROM Booking b")
    int findLatestBookingId();

}
