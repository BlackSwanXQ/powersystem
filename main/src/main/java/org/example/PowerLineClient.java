//package org.example;  // Исправлен package (не может содержать "main.java")
//
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//
//import java.util.Properties;
//
//public class PowerLineClient {
//    public static void main(String[] args) {
//        // 1. Создаем и настраиваем отправителя
//        JavaMailSender mailSender = getJavaMailSender();
//
//        // 2. Создаем сообщение
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo("theblack2swan@gmail.com");
//        message.setSubject("Test Email");
//        message.setText("This is a test email sent from Java application");
//
//        // 3. Отправляем сообщение
//        mailSender.send(message);
//        System.out.println("Email sent successfully!");
//    }
//
//    private static JavaMailSender getJavaMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//
//        // Настройки SMTP сервера (пример для Gmail)
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(587);
//        mailSender.setUsername("your-email@gmail.com");  // Замените на ваш email
//        mailSender.setPassword("your-password-or-app-password");  // Замените на пароль
//
//        Properties props = mailSender.getJavaMailProperties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.debug", "true");  // Для логгирования
//
//        return mailSender;
//    }
//}