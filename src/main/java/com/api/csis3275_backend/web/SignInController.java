package com.api.csis3275_backend.web;

import com.api.csis3275_backend.entities.Administrator;
import com.api.csis3275_backend.entities.Tourist;
import com.api.csis3275_backend.entities.TravelBuddy;
import com.api.csis3275_backend.repositories.AdminRepository;
import com.api.csis3275_backend.repositories.TravelBuddyRepository;
import com.api.csis3275_backend.repositories.TouristRepository;
import com.api.csis3275_backend.service.SignInService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class SignInController {

    AdminRepository adminRepository;
    TravelBuddyRepository travelBuddyRepository;
    TouristRepository touristRepository;
    @PostMapping(path = "/api/signIn")
    public ResponseEntity<?> signIn(@RequestBody SignInService signInRequest) {

        try {
            Optional<Administrator> adminData = adminRepository.findByUsername(signInRequest.getUsername());
            Optional<TravelBuddy> travelBuddyData = travelBuddyRepository.findByUsername(signInRequest.getUsername());
            List<Tourist> touristData = touristRepository.findByUsernameLike(signInRequest.getUsername());
            if (adminData.isPresent()) {
                String password = adminData.get().getPassword();
                if (password.equals(signInRequest.getPassword())) {
                    return new ResponseEntity<>("admin", HttpStatus.OK);
                }
                return new ResponseEntity<>("Incorrect password", HttpStatus.FORBIDDEN);
            } else if (travelBuddyData.isPresent()) {
                String password = travelBuddyData.get().getPassword();
                if (password.equals(signInRequest.getPassword())) {
                    return new ResponseEntity<>(travelBuddyData.get(), HttpStatus.OK);
                }
            } else if (!touristData.isEmpty()) {
                String password = touristData.get(0).getPassword();
                if (password.equals(signInRequest.getPassword())) {
                    return new ResponseEntity<>(touristData.get(0), HttpStatus.OK);
                }
            }
            return new ResponseEntity<>("No such user", HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            return new ResponseEntity<>("Server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
