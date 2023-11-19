package com.api.csis3275_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Entity
public class Tour {
    @Id
    private int tourID;
    private String tourName;
    private String location;
    private BigDecimal duration;
    private BigDecimal price;
    private String description;
    private String imageURL;

    public Tour(int tourID, String tourName, String location, BigDecimal duration, BigDecimal price, String description, String imageURL) {
        this.tourID = tourID;
        this.tourName = tourName;
        this.location = location;
        this.duration = duration;
        this.price = price;
        this.description = description;
        this.imageURL = imageURL;
    }

    public Tour() {

    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
