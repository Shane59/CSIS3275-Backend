package com.api.csis3275_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int adminID;
    @Getter
    private String username;
    @Getter
    private String password;

    public Administrator() {}
    public Administrator(int adminID, String username, String password) {
        adminID = adminID;
        username = username;
        password = password;
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
