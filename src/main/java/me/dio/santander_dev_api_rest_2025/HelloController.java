package me.dio.santander_dev_api_rest_2025;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello, Santander! Welcome to the API REST 2025!";
    }
}