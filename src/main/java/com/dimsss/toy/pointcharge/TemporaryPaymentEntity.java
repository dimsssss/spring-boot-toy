package com.dimsss.toy.pointcharge;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


@Builder
@Entity
@Table(name = "temporary_payments")
@Getter
public class TemporaryPaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;
    @Column(name = "order_id")
    private String orderId;
    private int amount;
    @Column(name = "payment_key")
    private String paymentKey;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
}
