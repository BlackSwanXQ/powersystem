import org.springframework.web.client.RestTemplate;

// PowerClient.java
public class PowerClient {
    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        // 1. Запрашиваем напряжение с Подстанции 1  
        double voltage = restTemplate.getForObject(
                "http://localhost:8081/voltage",
                Double.class
        );

        // 2. Передаём через Линию  
        String result = restTemplate.postForObject(
                "http://localhost:8082/transfer",
                voltage,
                String.class
        );

        System.out.println(result);
    }
}  