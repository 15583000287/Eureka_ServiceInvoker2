package com.example.eurekaserviceinvoke.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class InvokerController {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping("/router")
    public String router(){
        RestTemplate restTemplate = getRestTemplate();
        //根据应用名称调用服务
        String json = restTemplate.getForObject("http://service-provider/hello", String.class);
        return  json;
    }

    @RequestMapping("/router2")
    public String route2(){
        RestTemplate restTemplate = getRestTemplate();
        //根据应用名称调用服务
        String json = restTemplate.getForObject("http://service-provider/sayBye", String.class);
        return  json;
    }



}
