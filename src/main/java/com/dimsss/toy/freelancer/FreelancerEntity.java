package com.dimsss.toy.freelancer;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "freelancers")
public class FreelancerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;
    private String name;
    private int viewCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

