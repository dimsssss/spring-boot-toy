package com.dimsss.toy.pointcharge.infra.http;

public interface PgClient<T, P> {
    P requestPayment(T t);
}
