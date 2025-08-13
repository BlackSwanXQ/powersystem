package org.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

class PowerLineClient2 {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        // 1. Получаем напряжение (используем полный путь /api/voltage)
        String voltageUrl = "http://localhost:8081/api/power";
        String voltage = restTemplate.getForObject(voltageUrl, String.class);
        System.out.println("Получено напряжение: " + voltage + " кВ");

        // 2. Передаем через линию
        String powerlineUrl = "http://localhost:8082/api/transfer";
        String response = restTemplate.postForObject(
                powerlineUrl,
                voltage,
                String.class
        );
        System.out.println("Результат передачи: " + response);
    }
}