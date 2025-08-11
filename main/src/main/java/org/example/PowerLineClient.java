package org.example;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class PowerLineClient {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        // 1. Получаем напряжение
        String voltageUrl = "http://localhost:8081/voltage";
        String voltageStr = restTemplate.getForObject(voltageUrl, String.class);
        double voltage = Double.parseDouble(voltageStr);
        System.out.println("Получено напряжение: " + voltage + " кВ");

        // 2. Настраиваем заголовки для POST-запроса
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 3. Отправляем через линию передачи
        String powerlineUrl = "http://localhost:8082/line/transfer";
        String response = restTemplate.postForObject(
                powerlineUrl,
                new HttpEntity<>(String.valueOf(voltage), headers),
                String.class
        );

        System.out.println("Ответ от линии передачи: " + response);
    }
}