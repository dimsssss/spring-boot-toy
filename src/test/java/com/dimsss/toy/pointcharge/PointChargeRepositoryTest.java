package com.dimsss.toy.pointcharge;

import com.dimsss.toy.DatabaseClearAfrerAllExtension;
import com.dimsss.toy.lib.NotFoundException;
import com.dimsss.toy.pointcharge.domain.PointEntity;
import com.dimsss.toy.pointcharge.infra.http.PgType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(DatabaseClearAfrerAllExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PointChargeRepositoryTest {
    @Autowired
    private PointChargeRepository pointChargeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void findOneBy_throwNotFoundException() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            PointEntity point = pointChargeRepository.findOneBy(0);
        });
    }

    @Test
    void findOneBy() {
        PointEntity point = pointChargeRepository.findOneBy(1);
        assertEquals(point.getChargePoint(), 15000);
        assertEquals(point.getResultPoint(), 15000);
    }

    @Test
    void save() {
        PaymentEntity payment = PaymentEntity
                .builder()
                .paymentKey("B1d9edx08u7ic9yQqcTzj")
                .type(PgType.TOSS)
                .freelancerId(1)
                .orderId("chdimFOf9tnXV5u8Xqtlo")
                .status("DONE")
                .totalAmount(15000)
                .balanceAmount(15000)
                .suppliedAmount(13636)
                .vat(1364)
                .approveAt(LocalDateTime.parse("2022-06-08T15:40:09"))
                .requestedAt(LocalDateTime.parse("2022-06-08T15:40:09"))
                .build();

        PointEntity point = PointEntity.builder()
                .chargePoint(15000)
                .resultPoint(15000)
                .freelancerId(1)
                .build();

        pointChargeRepository.save(payment, point);

        PointEntity savedPoint = pointChargeRepository.findOneBy(1);

        assertEquals(savedPoint.getChargePoint(), 15000);
        assertEquals(savedPoint.getResultPoint(), 15000);
    }
}