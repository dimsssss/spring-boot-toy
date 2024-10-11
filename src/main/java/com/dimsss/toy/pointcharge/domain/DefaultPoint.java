package com.dimsss.toy.pointcharge.domain;

import com.dimsss.toy.pointcharge.PointChargeDto;

public class DefaultPoint implements PointPolicy {

    private int add(int chargePoint, int currentPoint) {
        return chargePoint + currentPoint;
    }

    @Override
    public PointEntity addPoint(PointChargeDto pointChargeDto, PointEntity point) {
        int result = add(pointChargeDto.getAmount(), point.getResultPoint());
        return PointEntity.builder()
                .freelancerId(point.getFreelancerId())
                .chargePoint(pointChargeDto.getAmount())
                .resultPoint(result)
                .build();
    }
}
