package com.mongo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class MongoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDemoApplication.class, args);
    }
}
