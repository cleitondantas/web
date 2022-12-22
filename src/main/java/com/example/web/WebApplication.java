package com.example.web;


import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@SpringBootApplication
@RestController
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
    public Long valueRandom= 0L;
    public Long contRequests= 0L;
    Logger logger = LoggerFactory.getLogger(WebApplication.class);

    @PostConstruct
    public void init(){
        valueRandom = new Random().nextLong();
    }
    @GetMapping("/")
    public String status(){
        logger.info("------UP-----");
        return "UP";
    }

    @GetMapping("/pod")
    public String random(){
        contRequests++;
        logger.info("pod: "+this.valueRandom +" Cont Requests: "+contRequests);
        return "pod: "+this.valueRandom;
    }
}


