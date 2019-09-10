package com.marco.stockservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Deprecated //unused
@Configuration
public class BeansConfiguration {

    @Deprecated //we use Feign
    @Bean("restTemplate")
//    @LoadBalanced //necessary for RestTemplate to work with Eureka
    public RestTemplate registerRestTemplate(){
        return new RestTemplate();
    }
}
