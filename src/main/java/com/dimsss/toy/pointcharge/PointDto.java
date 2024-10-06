package com.dimsss.toy.pointcharge;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PointDto {
    private int freelancerId;
    private int chargePoint;
    private int resultPoint;
}
