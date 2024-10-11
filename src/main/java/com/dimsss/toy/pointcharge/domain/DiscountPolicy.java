package com.dimsss.toy.pointcharge.domain;

import com.dimsss.toy.pointcharge.PointChargeDto;

public interface DiscountPolicy {
    PointChargeDto discount(PointChargeDto pointChargeDto);
}
