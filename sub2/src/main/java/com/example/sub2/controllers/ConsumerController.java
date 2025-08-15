package com.example.sub2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ConsumerController {
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/current-power")
    public ResponseEntity<String> getPower() {
        try {
            ResponseEntity<Integer> response = restTemplate.getForEntity(
                    "http://powerline:8080/api/current-power",
                    Integer.class
            );

            if (response.getStatusCode() == HttpStatus.OK) {
                return ResponseEntity.ok("Текущая мощность: " + response.getBody());
            } else {
                return ResponseEntity.status(response.getStatusCode())
                        .body("Ошибка получения данных: " + response.getStatusCode());
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Сервис временно недоступен");
        }
    }
}