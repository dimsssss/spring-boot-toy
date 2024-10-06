package com.dimsss.toy.freelancer;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DialectOverride;

import java.time.LocalDateTime;

@Builder
@Entity
@Table(name = "freelancer_view_log")
@Getter
public class FreelancerViewLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int freelancerId;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
