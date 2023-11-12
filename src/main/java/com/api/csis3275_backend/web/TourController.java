package com.api.csis3275_backend.web;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class TourController {

    @GetMapping(path = "/index")
    public String test(Model model, @RequestParam(name="keyword", defaultValue = "") String keyword) {

        return "test";
    }
}
