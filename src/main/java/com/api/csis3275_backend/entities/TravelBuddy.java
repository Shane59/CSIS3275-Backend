package com.api.csis3275_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class TravelBuddy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int travelBuddyID;
    private String firstName;
    private String lastName;
    private String email;
    private String description;
    private String username;
    private String password;
    private String resumeURL;
    private String profileImageURL;

    @Column(columnDefinition = "varchar(20) default 'Pending'")
    private String applicationStatus;
    private float averageStarRate;


    public TravelBuddy( String firstName, String lastName, String email, String description, String username, String password, String applicationStatus, String resumeURL, String profileImageURL, float averageStarRate) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.description = description;
        this.username = username;
        this.password = password;
        this.applicationStatus = applicationStatus;
        this.resumeURL = resumeURL;
        this.profileImageURL= profileImageURL;
        this.averageStarRate = averageStarRate;
    }

    public TravelBuddy() {

    }
    public void setAverageStarRate(float averageStarRate) {
        this.averageStarRate = averageStarRate;
    }

    public void setTravelBuddyID(int travelBuddyID) {
        this.travelBuddyID = travelBuddyID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) { this.password = password; }
    public void setResumeURL(String resumeURL) {
        this.resumeURL = resumeURL;
    }

    public void setProfileImageURL(String profileImageURL) {
        this.profileImageURL = profileImageURL;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
