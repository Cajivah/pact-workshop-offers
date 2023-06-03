package com.jmalyjasiak.pactworkshop.offer.client


import au.com.dius.pact.consumer.groovy.PactBuilder
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

import static org.junit.jupiter.api.Assertions.assertEquals

@SpringBootTest
class PromotionsContractTest {

    @Autowired
    PromotionsClient promotionsClient

    private int serverPort = 8080

    @Test
    void "Should return promotion given promotion id"() {
        def pact = new PactBuilder()

        pact {
            serviceConsumer 'offer'
            hasPactWith 'promotions'
            port serverPort
            uponReceiving 'a get request for all promotion'
            withAttributes(
                    method: 'GET',
                    path: '/promotions/some-promotion-id'
            )
            willRespondWith(
                    status: 200,
                    headers: [
                            'Content-Type': 'application/json'
                    ]
            )
            withBody {
                promotionId string('some-promotion-id')
            }
        }

        pact.runTestAndVerify {
            var promotion = promotionsClient.getPromotion("some-promotion-id")

            assertEquals("some-promotion-id", promotion.promotionId())
        }
    }
}