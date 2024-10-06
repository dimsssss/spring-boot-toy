package com.dimsss.toy.pointcharge;

import com.dimsss.toy.pointcharge.infra.http.PgType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Entity
@Table(name = "payments")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;
    @Column(name = "pg_type")
    private PgType type;
    @Column(name = "freelancer_id")
    private int freelancerId;
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "payment_key")
    private String paymentKey;
    private String status;
    private int totalAmount;
    private int balanceAmount;
    private int suppliedAmount;
    private int vat;
    private LocalDateTime createdAt;
    private LocalDateTime approveAt;
    private LocalDateTime requestedAt;

}
