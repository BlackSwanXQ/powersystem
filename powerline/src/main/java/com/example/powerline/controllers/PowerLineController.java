package com.example.powerline.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PowerLineController {
    private Integer currentPower;
    private final Object lock = new Object();

    @PostMapping("/transfer")
    public ResponseEntity<String> savePower(@RequestBody Integer power) {
        synchronized (lock) {
            this.currentPower = power;
        }
        return ResponseEntity.ok("Мощность " + power + " сохранена");
    }

    @GetMapping("/current-power")
    public ResponseEntity<Integer> getPower() {
        synchronized (lock) {
            if (currentPower == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(currentPower);
        }
    }
}