package com.dimsss.toy.pointcharge.domain;

import com.dimsss.toy.pointcharge.PointChargeDto;

public class DefaultDiscount implements DiscountPolicy<PointChargeDto, PointChargeDto> {
    @Override
    public PointChargeDto discount(PointChargeDto pointChargeDto) {
        return pointChargeDto;
    }
}
