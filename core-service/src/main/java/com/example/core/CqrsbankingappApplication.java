package com.example.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties
@EntityScan(basePackages ="com.example")
@ComponentScan(basePackages = "com.example")
@EnableJpaRepositories(basePackages = "com.example.*")
public class CqrsbankingappApplication {

    public static void main(String[] args) {
        SpringApplication.run(CqrsbankingappApplication.class, args);
    }

}
