package com.dimsss.toy.pointcharge.domain;

import com.dimsss.toy.pointcharge.PointChargeDto;

public interface PointPolicy {
    PointEntity addPoint(PointChargeDto pointChargeDto, PointEntity pointEntity);
}
