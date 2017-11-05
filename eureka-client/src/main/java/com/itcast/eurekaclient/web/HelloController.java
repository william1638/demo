package com.itcast.eurekaclient.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping("/dc")
    public String dc() throws InterruptedException {
        int sleepTime = new Random().nextInt(4000);
        Thread.sleep(sleepTime);
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }
}
