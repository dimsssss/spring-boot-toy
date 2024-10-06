package com.dimsss.toy.pointcharge;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TemporaryPaymentRepositoryTest {
    @Autowired
    private TemporaryPaymentRepository temporaryPaymentRepository;

    @Test
    void save() {
        PointChargeDto pointChargeDto = PointChargeDto.builder().orderId("!@#").paymentKey("asdad").amount(100).build();

        TemporaryPaymentEntity temporaryPaymentEntity = this.temporaryPaymentRepository.save(pointChargeDto);

        assertEquals(temporaryPaymentEntity.getOrderId(), pointChargeDto.getOrderId());
    }
}