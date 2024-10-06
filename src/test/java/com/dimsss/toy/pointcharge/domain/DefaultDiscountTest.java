package com.dimsss.toy.pointcharge.domain;

import com.dimsss.toy.pointcharge.PointChargeDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultDiscountTest {

    private DefaultDiscount defaultDiscount = new DefaultDiscount();

    @Test
    void discount() {
        PointChargeDto pointChargeDto = PointChargeDto.builder()
                .orderId("test")
                .discountType(DiscountType.NONE)
                .amount(1000)
                .build();

        assertEquals(defaultDiscount.discount(pointChargeDto).getAmount(), 1000);
    }
}