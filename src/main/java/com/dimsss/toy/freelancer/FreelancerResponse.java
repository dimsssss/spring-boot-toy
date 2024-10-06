package com.dimsss.toy.freelancer;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Builder
@Getter
public class FreelancerResponse {
    private int id;
    private String name;
    private int viewCount;
    private LocalDateTime createdAt;
}
