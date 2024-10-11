package com.dimsss.toy.pointcharge;

import com.dimsss.toy.pointcharge.domain.DiscountType;
import com.dimsss.toy.pointcharge.domain.PointType;
import com.dimsss.toy.pointcharge.infra.http.PgType;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@ToString
@Getter
@AllArgsConstructor
public class PointChargeDto {
    private int freelancerId;
    @NotNull
    private PgType pgType;
    @NotNull
    private PointType pointType;
    @NotNull
    private DiscountType discountType;
    private String orderId;
    private int amount;
    private String paymentKey;

    protected PointChargeDto() {}
}
