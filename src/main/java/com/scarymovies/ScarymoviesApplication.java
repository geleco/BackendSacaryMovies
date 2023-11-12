package com.scarymovies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.scarymovies.repository")
@EntityScan("com.scarymovies.entity")
public class ScarymoviesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScarymoviesApplication.class, args);
    }

}
