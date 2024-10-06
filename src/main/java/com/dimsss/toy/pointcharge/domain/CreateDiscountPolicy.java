package com.dimsss.toy.pointcharge.domain;

import com.dimsss.toy.pointcharge.PointChargeDto;
import org.springframework.stereotype.Component;

@Component
public class CreateDiscountPolicy {
    public DiscountPolicy<PointChargeDto, PointChargeDto> createDiscountPolicy(DiscountType type) {
        return new DefaultDiscount();
    }
}
