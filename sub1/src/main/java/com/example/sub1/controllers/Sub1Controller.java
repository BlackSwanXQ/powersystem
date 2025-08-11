package com.example.sub1.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Sub1Controller {

    @GetMapping(value = "/voltage",
            produces = "text/plain")
    public String getVoltage() {
        return "220.0";
    }
}