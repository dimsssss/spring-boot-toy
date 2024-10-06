package com.dimsss.toy.pointcharge.infra.http;

import com.dimsss.toy.pointcharge.PaymentEntity;
import com.dimsss.toy.pointcharge.PointChargeDto;

import lombok.Builder;
import org.springframework.stereotype.Component;

@Builder
@Component
public class CreatePgClient {
    private PgHttpClient pgHttpClient;

    CreatePgClient(PgHttpClient pgHttpClient) {
        this.pgHttpClient = pgHttpClient;
    }

    public PgClient<PointChargeDto, PaymentEntity> create(PgType type) {
        return new TossPgClient(pgHttpClient, type);
    }
}
