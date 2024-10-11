package com.dimsss.toy.pointcharge.domain;

import com.dimsss.toy.pointcharge.PointChargeDto;
import com.dimsss.toy.pointcharge.infra.http.PgType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultDiscountTest {

    private DefaultDiscount defaultDiscount = new DefaultDiscount();

    @Test
    void discount() {
        PointChargeDto pointChargeDto = new PointChargeDto(1, PgType.TOSS, PointType.NONE, DiscountType.NONE, "test", 1000, "");

        assertEquals(defaultDiscount.discount(pointChargeDto).getAmount(), 1000);
    }
}