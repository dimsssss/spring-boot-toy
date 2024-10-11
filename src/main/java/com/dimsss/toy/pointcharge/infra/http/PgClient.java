package com.dimsss.toy.pointcharge.infra.http;

import com.dimsss.toy.pointcharge.PaymentEntity;
import com.dimsss.toy.pointcharge.PointChargeDto;

public interface PgClient {
    PaymentEntity requestPayment(PointChargeDto pointChargeDto);
}
