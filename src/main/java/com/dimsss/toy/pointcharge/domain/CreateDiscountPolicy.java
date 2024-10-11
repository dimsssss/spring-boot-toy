package com.dimsss.toy.pointcharge.domain;

import org.springframework.stereotype.Component;

@Component
public class CreateDiscountPolicy {
    public DiscountPolicy createDiscountPolicy(DiscountType type) {
        return new DefaultDiscount();
    }
}
