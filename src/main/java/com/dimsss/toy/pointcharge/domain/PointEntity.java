package com.dimsss.toy.pointcharge.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "points")
@Builder
@AllArgsConstructor
public class PointEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;
    @Column(name = "freelancer_id")
    private int freelancerId;
    @Column(name = "charge_point")
    private int chargePoint;
    @Column(name = "result_point")
    private int resultPoint;
    private LocalDateTime createdAt;

    protected PointEntity() {}
}
