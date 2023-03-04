package com.example.techeer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StarterApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(StarterApiApplication.class, args);
    }
}
