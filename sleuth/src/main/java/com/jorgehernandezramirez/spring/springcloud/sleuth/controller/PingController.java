package com.jorgehernandezramirez.spring.springcloud.sleuth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PingController {

    private static Logger LOGGER = LoggerFactory.getLogger(PingController.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/ping")
    public String doPing(){
        LOGGER.info("Realizando ping...");
        return "Alive!";
    }

    @RequestMapping("/rest/ping")
    public String doRestPing(){
        LOGGER.info("Realizando rest ping...");
        return restTemplate.getForObject("http://localhost:8080/ping", String.class);
    }
}
