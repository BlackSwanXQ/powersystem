package com.example.sub1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sub2Controller {

        @GetMapping("/voltage")
        public double getVoltage() {
            return 220.0; // Напряжение в кВт
    }
}
