package com.example.sub2.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sub2Controller {
    @PostMapping("/receive")
    public String receive(@RequestBody double power) {
        return String.format("Подстанция 2: принято %.1f кВт", power);
    }
}
