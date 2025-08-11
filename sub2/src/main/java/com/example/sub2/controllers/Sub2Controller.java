package com.example.sub2.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Sub2Controller {

    @PostMapping(value = "/receive",
            consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String receive(@RequestBody String power) {
        return "Принято " + power + " кВт";
    }
}