package org.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Main {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        // Тест полной цепочки
        for (int i = 0; i <100 ; i++) {
            testFullFlow(restTemplate, i);
        }


        // Тест получения данных
        testGetPower(restTemplate);
    }

    private static void testFullFlow(RestTemplate restTemplate, int power) {
        try {
            // 1. Отправляем данные в Sub1
            String sub1Response = restTemplate.postForObject(
                    "http://localhost:8081/api/power-sub1",
                    power,
                    String.class
            );
            System.out.println(sub1Response);

            // 2. Получаем данные через Sub2
            ResponseEntity<String> sub2Response = restTemplate.getForEntity(
                    "http://localhost:8083/api/current-power",
                    String.class
            );
            System.out.println(sub2Response.getBody());

        } catch (Exception e) {
            System.err.println("Ошибка тестирования: " + e.getMessage());
        }
    }

    private static void testGetPower(RestTemplate restTemplate) {
        try {
            ResponseEntity<Integer> response = restTemplate.getForEntity(
                    "http://localhost:8082/api/current-power",
                    Integer.class

            );

            if (response.getStatusCode() == HttpStatus.OK) {
                System.out.println("Текущая мощность (прямой запрос): " + response.getBody());
            } else {
                System.out.println("Данные не найдены");
            }
        } catch (Exception e) {
            System.err.println("Ошибка прямого запроса: " + e.getMessage());
        }
    }
}