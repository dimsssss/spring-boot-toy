package com.dimsss.toy.pointcharge.domain;

import com.dimsss.toy.pointcharge.PointChargeDto;
import com.dimsss.toy.pointcharge.infra.http.PgType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultPointTest {
    private DefaultPoint defaultPoint = new DefaultPoint();

    @Test
    void addPoint() {
        PointChargeDto pointChargeDto = new PointChargeDto(1, PgType.TOSS, PointType.NONE, DiscountType.NONE, "!@#", 1000, "asdad");

        PointEntity point = PointEntity.builder()
                        .chargePoint(0)
                        .resultPoint(0)
                        .build();

        assertEquals(defaultPoint.addPoint(pointChargeDto, point).getResultPoint(), 1000);
    }
}