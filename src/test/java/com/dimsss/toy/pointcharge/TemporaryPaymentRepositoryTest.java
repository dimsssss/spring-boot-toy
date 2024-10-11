package com.dimsss.toy.pointcharge;

import com.dimsss.toy.pointcharge.domain.DiscountType;
import com.dimsss.toy.pointcharge.domain.PointType;
import com.dimsss.toy.pointcharge.infra.http.PgType;
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
        PointChargeDto pointChargeDto = new PointChargeDto(1, PgType.TOSS, PointType.NONE, DiscountType.NONE, "!@#", 100, "asdad");

        TemporaryPaymentEntity temporaryPaymentEntity = this.temporaryPaymentRepository.save(pointChargeDto);

        assertEquals(temporaryPaymentEntity.getOrderId(), pointChargeDto.getOrderId());
    }
}