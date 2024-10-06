package com.dimsss.toy.pointcharge.domain;

import com.dimsss.toy.pointcharge.PointChargeDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultPointTest {
    private DefaultPoint defaultPoint = new DefaultPoint();

    @Test
    void addPoint() {
        PointChargeDto pointChargeDto = PointChargeDto.builder()
                        .amount(1000)
                        .pointType(PointType.NONE)
                        .build();

        PointEntity point = PointEntity.builder()
                        .chargePoint(0)
                        .resultPoint(0)
                        .build();

        assertEquals(defaultPoint.addPoint(pointChargeDto, point).getResultPoint(), 1000);
    }
}