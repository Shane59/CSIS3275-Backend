package com.api.csis3275_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminID;
    private String username;
    private String password;

    public Administrator() {}
    public Administrator(int adminID, String username, String password) {
        this.adminID = adminID;
        this.username = username;
        this.password = password;
    }

    public void setAdminId(int adminID) {
        this.adminID = adminID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
