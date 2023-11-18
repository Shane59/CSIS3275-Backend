package com.api.csis3275_backend.repositories;

import com.api.csis3275_backend.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour,Long> {
    List<Tour> findByTourID(long tourID);
    List<Tour> findByTourNameLike(String name);
    List<Tour> findByLocationLike(String location);
    @Override
    Tour save(Tour tour);

    @Query("SELECT MAX(t.tourID) FROM Tour t")
    int findLatestTourId();
}
