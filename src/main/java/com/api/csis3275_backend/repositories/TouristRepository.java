package com.api.csis3275_backend.repositories;

import com.api.csis3275_backend.entities.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TouristRepository extends JpaRepository<Tourist, Long> {
    List<Tourist> findAll();
    List<Tourist> findByFirstnameLike(String firstname);
    List<Tourist> findByLastnameLike(String lastname);
    List<Tourist> findByUsernameLike(String username);
    List<Tourist> findByTouristID(long id);
    Tourist save(Tourist tourist);

    @Query("SELECT MAX(t.touristID) FROM Tourist t")
    int findLatestTouristId();
}
