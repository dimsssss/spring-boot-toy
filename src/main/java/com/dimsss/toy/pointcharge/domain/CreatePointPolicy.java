package com.dimsss.toy.pointcharge.domain;

import org.springframework.stereotype.Component;

@Component
public class CreatePointPolicy {
    public PointPolicy createPointPolicy(PointType type) {
        return new DefaultPoint();
    }
}
