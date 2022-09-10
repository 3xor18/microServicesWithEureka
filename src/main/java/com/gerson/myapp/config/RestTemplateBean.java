package com.gerson.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//Esta Clase te permite registrar un bean (clase virtual) para consumir apis (comunicar con otros micro services)
@Configuration
public class RestTemplateBean {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}