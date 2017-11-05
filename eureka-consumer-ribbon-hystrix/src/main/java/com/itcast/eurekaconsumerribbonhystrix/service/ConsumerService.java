package com.itcast.eurekaconsumerribbonhystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author William
 * @date 2017/11/4
 */
@Service
public class ConsumerService {
    Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @Autowired
    public RestTemplate restTemplate ;


    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer(){
        long start = System.currentTimeMillis();
        String result =  restTemplate.getForObject("http://eureka-client/dc",String.class);
        long end = System.currentTimeMillis();
        logger.info("speed time"+(end-start));
        return result ;

    }

    public String fallback(){
        return "fallback";
    }

}
