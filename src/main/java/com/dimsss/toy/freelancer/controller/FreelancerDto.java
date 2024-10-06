package com.dimsss.toy.freelancer.controller;

import lombok.*;


@ToString
@Setter
@Getter
@Builder
@AllArgsConstructor
public class FreelancerDto {
    private SortType sort;
    private int lastId;
    private int limit;
}
