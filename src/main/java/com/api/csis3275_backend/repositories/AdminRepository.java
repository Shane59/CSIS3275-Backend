package com.api.csis3275_backend.repositories;

import com.api.csis3275_backend.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Administrator,Long> {
    @Query(value = "SELECT * FROM Administrator WHERE adminId = :adminId", nativeQuery = true)
    List<Administrator> findByAdminId(long adminId);

    @Query(value = "SELECT * FROM Administrator WHERE username = :username", nativeQuery = true)
    Optional<Administrator> findByUsername(String username);

}
