package com.example.selfmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.selfmonitor.dao.repository")
@EntityScan("com.example.selfmonitor.model.entity")
@SpringBootApplication
public class SelfMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelfMonitorApplication.class, args);
    }

}
