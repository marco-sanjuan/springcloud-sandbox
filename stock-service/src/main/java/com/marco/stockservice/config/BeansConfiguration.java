package com.marco.stockservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeansConfiguration {

    @Bean("restTemplate")
    @LoadBalanced
    public RestTemplate registerRestTemplate(){
        return new RestTemplate();
    }
}
