package com.volzhin.url_shortener.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class AppConfig {
    @Value("${spring.threads}")
    private int threads;

    @Bean
    ExecutorService executorService() {
        return Executors.newFixedThreadPool(threads);
    }
}