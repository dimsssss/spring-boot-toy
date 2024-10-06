package com.dimsss.toy.pointcharge;

import com.dimsss.toy.pointcharge.domain.DiscountType;
import com.dimsss.toy.pointcharge.domain.PointType;
import com.dimsss.toy.pointcharge.infra.http.PgType;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class PointChargeDto {
    private int freelancerId;
    @NotNull
    private final PgType pgType;
    @NotNull
    private final PointType pointType;
    @NotNull
    private final DiscountType discountType;
    private String orderId;
    private int amount;
    private String paymentKey;
}
