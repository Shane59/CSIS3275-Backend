package com.api.csis3275_backend.web;

import com.api.csis3275_backend.entities.Tourist;
import com.api.csis3275_backend.repositories.TouristRepository;
import com.api.csis3275_backend.service.TouristService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TouristController {
    @Autowired
    TouristRepository touristRepository;
    @Autowired
    TouristService touristService;


    @GetMapping("/api/tourist")
    public List<Tourist> tourists(Model model, @RequestParam(name = "id", defaultValue = "") String id,
                                  @RequestParam(name = "firstname", defaultValue = "") String firstname,
                                  @RequestParam(name = "lastname", defaultValue = "") String lastname,
                                  @RequestParam(name = "username", defaultValue = "") String username) {
        if (id.isEmpty() && firstname.isEmpty() && lastname.isEmpty() && username.isEmpty()) {
            return touristRepository.findAll();
        }
        if (!id.isEmpty()) {
            long key = Long.parseLong(id);
            return touristRepository.findByTouristID(key);
        } else if (!firstname.isEmpty()) {
            return touristRepository.findByFirstnameLike("%" + firstname + "%");
        } else if (!lastname.isEmpty()) {
            return touristRepository.findByLastnameLike("%" + lastname + "%");
        }
        return touristRepository.findByUsernameLike("%" + username + "%");
    }

    @PostMapping("/api/tourist/create")
    public ResponseEntity<Tourist> createTourist(
            @RequestParam(name = "firstname") String firstname,
            @RequestParam(name = "lastname") String lastname,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "preference") String preference) {
        Tourist newTourist = touristService.createNewTourist(firstname, lastname,
                email, username, password, preference);
        return new ResponseEntity<>(newTourist, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/tourist/delete/{touristID}")
    public ResponseEntity<Long> deleteTourist(@PathVariable long touristID) {
        touristRepository.deleteById(touristID);
        return new ResponseEntity<>(touristID, HttpStatus.OK);
    }

    @PutMapping("/api/tourist/update/{touristID}")
    public ResponseEntity<Tourist> updateTourist(@PathVariable long touristID,
                                                 @RequestParam(name = "firstname", defaultValue = "") String firstname,
                                                 @RequestParam(name = "lastname", defaultValue = "") String lastname,
                                                 @RequestParam(name = "email", defaultValue = "") String email,
                                                 @RequestParam(name = "username", defaultValue = "") String username,
                                                 @RequestParam(name = "preference", defaultValue = "") String preference) {
        Tourist existedTourist = touristRepository.findByTouristID(touristID).get(0);
        if (!firstname.isEmpty()) {
            existedTourist.setFirstname(firstname);
        } else if (!lastname.isEmpty()) {
            existedTourist.setLastname(lastname);
        } else if (!email.isEmpty()) {
            existedTourist.setEmail(email);
        } else if (!username.isEmpty()) {
            existedTourist.setUsername(username);
        } else if (!preference.isEmpty()) {
            existedTourist.setPreference(preference);
        }
        Tourist updatedTourist = touristRepository.save(existedTourist);
        return new ResponseEntity<>(updatedTourist, HttpStatus.OK);
    }
}
