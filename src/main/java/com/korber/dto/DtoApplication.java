package com.korber.dto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@Slf4j
@SpringBootApplication
@EnableAsync
public class DtoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DtoApplication.class, args);
    }
}
