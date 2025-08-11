package com.example.powerline.controllers;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class PowerLineController {

    private final RestTemplate restTemplate;

    public PowerLineController() {
        this.restTemplate = new RestTemplate();
    }

    @PostMapping(value = "/transfer",
            consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> transfer(@RequestBody String power) {
        try {
            double powerValue = Double.parseDouble(power);
            double powerAfterLoss = powerValue * 0.9;

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.TEXT_PLAIN);

            String response = restTemplate.exchange(
                    "http://sub2:8080/api/receive",
                    HttpMethod.POST,
                    new HttpEntity<>(String.valueOf(powerAfterLoss), headers),
                    String.class
            ).getBody();

            return ResponseEntity.ok("Передано: " + powerAfterLoss + " кВт. " + response);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ошибка: " + e.getMessage());
        }
    }
}