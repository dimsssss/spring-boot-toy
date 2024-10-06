package com.dimsss.toy.pointcharge.infra.http;

import lombok.Getter;

@Getter
public enum PgType {
    TOSS("toss", "https://api.tosspayments.com/v1/payments/confirm", "test_gsk_docs_OaPz8L5KdmQXkzRz3y47BMw6");

    private final String type;
    private final String url;
    private final String code;

    PgType(String type, String url, String code) {
        this.type = type;
        this.url = url;
        this.code = code;
    }

    private boolean isPgType(String source) {
        return this.getType().equalsIgnoreCase(source);
    }

    public static PgType fromField(String source) {
        try {
            for (PgType type : PgType.values()) {
                if (type.isPgType(source)) {
                    return type;
                }
            }

            throw new IllegalArgumentException("Invalid pg type: " + source);
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new IllegalArgumentException("Invalid spg type: " + source);
        }
    }
}
