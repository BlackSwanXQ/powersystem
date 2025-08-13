import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class PowerClient {
    public static void main(String[] args) {
//        HttpClient client = HttpClient.newBuilder()
//                .connectTimeout(Duration.ofSeconds(5))
//                .build();
//
//        try {
//            // 1. Запрос напряжения с Подстанции 1
//            HttpRequest getRequest = HttpRequest.newBuilder()
//                    .uri(URI.create("http://localhost:8081/api/voltage"))
//                    .GET()
//                    .build();
//
//            String voltage = client.send(getRequest, HttpResponse.BodyHandlers.ofString()).body();
//            System.out.println("Получено напряжение: " + voltage);
//
//            // 2. Передача через Линию
//            HttpRequest postRequest = HttpRequest.newBuilder()
//                    .uri(URI.create("http://localhost:8082/api/transfer"))
//                    .header("Content-Type", "text/plain")
//                    .POST(HttpRequest.BodyPublishers.ofString(voltage))
//                    .build();
//
//            String response = client.send(postRequest, HttpResponse.BodyHandlers.ofString()).body();
//            System.out.println("Результат: " + response);
//
//        } catch (Exception e) {
//            System.err.println("Ошибка: " + e.getMessage());
//        }


    }
}