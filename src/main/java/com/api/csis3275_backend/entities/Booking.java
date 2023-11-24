package com.api.csis3275_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Entity
public class Booking {
    @Id
    private int bookingID;
    private int touristID;
    private int travelBuddyID;
    private int tourID;
    private Date bookingDate;
    private String imageURL;
    private Time startTime;

    public Booking() {
    }

    public Booking(int bookingID, int touristID, int travelBuddyID, int tourID, Date bookingDate, String imageURL, Time startTime) {
        this.bookingID = bookingID;
        this.touristID = touristID;
        this.travelBuddyID = travelBuddyID;
        this.tourID = tourID;
        this.bookingDate = bookingDate;
        this.imageURL = imageURL;
        this.startTime = startTime;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public void setTouristID(int touristID) {
        this.touristID = touristID;
    }

    public void setTravelBuddyID(int travelBuddyID) {
        this.travelBuddyID = travelBuddyID;
    }

    public void setTourID(int tourID) {
        this.tourID = tourID;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

}
