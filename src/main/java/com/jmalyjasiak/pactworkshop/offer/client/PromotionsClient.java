package com.jmalyjasiak.pactworkshop.offer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("promotions")
public interface PromotionsClient {

    @GetMapping("/promotions")
    List<Promotion> getAllPromotions();

    @GetMapping("/promotions/{promotionId}")
    Promotion getPromotion(@PathVariable("promotionId") String promotionId);

    record Promotion(
            String promotionId
    ) {
    }
}
