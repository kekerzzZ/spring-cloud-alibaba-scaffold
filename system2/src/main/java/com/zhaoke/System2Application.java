package com.zhaoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDiscoveryClient
public class System2Application {
    public static void main(String[] args) {
        SpringApplication.run(System2Application.class, args);
    }
}
