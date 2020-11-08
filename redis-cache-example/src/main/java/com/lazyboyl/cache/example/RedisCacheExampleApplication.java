package com.lazyboyl.cache.example;

import com.lazyboyl.cache.annotation.RedisCacheConfig;
import com.lazyboyl.cache.scanner.EnableWebSocketServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableWebSocketServer
public class RedisCacheExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisCacheExampleApplication.class, args);
    }

}
