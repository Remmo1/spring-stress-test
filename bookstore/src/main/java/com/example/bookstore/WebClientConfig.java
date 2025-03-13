package com.example.bookstore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient ratingWebClient() {
        return WebClient.builder()
            .baseUrl("http://localhost:8082")
            .build();
    }

    @Bean
    public WebClient validateWebClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8081")
                .build();
    }
}