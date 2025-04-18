package org.example.l18pr.config;

import org.example.l18pr.dto.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class OrderMemorySave {

    @Bean
    public Map<Integer, Order> orders (){
        return new HashMap<>();
    }
}