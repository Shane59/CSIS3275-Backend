package com.api.csis3275_backend.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Tourist {
    @Id
    private int touristID;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private String preference;

    public Tourist() {
    }

    public Tourist(int touristID, String firstname, String lastname, String email, String username, String password, String preference) {
        this.touristID = touristID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.preference = preference;
    }

    public void setTouristID(int touristID) {
        this.touristID = touristID;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}
