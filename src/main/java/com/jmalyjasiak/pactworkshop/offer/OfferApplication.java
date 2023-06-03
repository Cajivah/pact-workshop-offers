package com.jmalyjasiak.pactworkshop.offer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OfferApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfferApplication.class, args);
    }

}
