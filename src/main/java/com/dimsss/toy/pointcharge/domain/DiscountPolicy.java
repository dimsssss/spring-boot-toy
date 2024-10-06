package com.dimsss.toy.pointcharge.domain;

public interface DiscountPolicy<T, P> {
    P discount(T t);
}
