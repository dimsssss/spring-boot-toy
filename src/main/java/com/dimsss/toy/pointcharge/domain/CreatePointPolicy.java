package com.dimsss.toy.pointcharge.domain;

import com.dimsss.toy.pointcharge.PointChargeDto;
import org.springframework.stereotype.Component;

@Component
public class CreatePointPolicy {
    public PointPolicy<PointChargeDto, PointEntity, PointEntity> createPointPolicy(PointType type) {
        return new DefaultPoint();
    }
}
