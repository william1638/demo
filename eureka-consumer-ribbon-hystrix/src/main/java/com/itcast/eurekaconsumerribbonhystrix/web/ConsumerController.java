package com.itcast.eurekaconsumerribbonhystrix.web;

import com.itcast.eurekaconsumerribbonhystrix.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author William
 * @date 2017/11/4
 */
@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;


    @GetMapping("/consumer")
    public String consumer(){
        return consumerService.consumer();
    }
}
