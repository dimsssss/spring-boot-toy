package com.dimsss.toy.pointcharge.domain;

import com.dimsss.toy.pointcharge.PointChargeDto;

public interface PointPolicy<T, P, R> {
    P addPoint(T t, R r);
}
