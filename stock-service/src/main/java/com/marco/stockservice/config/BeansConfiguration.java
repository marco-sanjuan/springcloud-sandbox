package com.marco.stockservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@Deprecated //unused
public class BeansConfiguration {

    @Bean("restTemplate")
    @Deprecated //we use Feign
    public RestTemplate registerRestTemplate(){
        return new RestTemplate();
    }
}
