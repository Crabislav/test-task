package com.ak.testtask.config;

import com.ak.testtask.exceptionhandlers.RestTemplateErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .errorHandler(new RestTemplateErrorHandler())
                .build();
    }
}
