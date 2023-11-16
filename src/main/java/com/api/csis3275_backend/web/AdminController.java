package com.api.csis3275_backend.web;

import com.api.csis3275_backend.entities.Administrator;
import com.api.csis3275_backend.repositories.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AdminController {

    @Autowired
    AdminRepository adminRepository;

    @GetMapping("/api/admin")
    public List<Administrator> admin(Model model, @RequestParam(name="id", defaultValue = "") String id) {
        if (id.isEmpty()) {
            return adminRepository.findAll();
        }
        long key = Long.parseLong(id);
        return adminRepository.findByAdminId(key);
    }

}
