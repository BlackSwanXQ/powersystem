package com.example.powerline.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

// PowerLineController.java
@RestController
public class PowerLineController {
    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/transfer")
    public String transfer(@RequestBody double power) {
        double powerAfterLoss = power * 0.9; // Потери 10%

        String response = restTemplate.postForObject(
                "http://substation2:8080/receive",
                powerAfterLoss,
                String.class
        );

        return String.format("Линия: передано %.1f кВт. %s", powerAfterLoss, response);
    }
}  