package com.example.sub1.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Sub1Controller {

    @GetMapping(value = "/power",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String getVoltage() {
        return "220.0";
    }
}