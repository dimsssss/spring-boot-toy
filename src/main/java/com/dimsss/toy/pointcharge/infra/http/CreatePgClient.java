package com.dimsss.toy.pointcharge.infra.http;

import lombok.Builder;
import org.springframework.stereotype.Component;

@Builder
@Component
public class CreatePgClient {
    private PgHttpClient pgHttpClient;

    public CreatePgClient(PgHttpClient pgHttpClient) {
        this.pgHttpClient = pgHttpClient;
    }

    public PgClient create(PgType type) {
        return new TossPgClient(pgHttpClient, type);
    }
}
