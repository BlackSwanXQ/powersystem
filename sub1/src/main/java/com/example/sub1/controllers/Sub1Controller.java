package com.example.sub1.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class Sub1Controller {
    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/power-sub1")
    public String receivePower(@RequestBody Integer power) {
        String response = restTemplate.postForObject(
                "http://powerline:8080/api/transfer",
                power,
                String.class
        );
        return "Данные переданы: " + response;
    }
}