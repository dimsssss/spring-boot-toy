package com.dimsss.toy.pointcharge.domain;

import lombok.Getter;

@Getter
public enum DiscountType {
    NONE("none");

    private final String type;

    DiscountType(String type) {
        this.type = type;
    }

    private boolean isDiscountType(String source) {
        return this.getType().equalsIgnoreCase(source);
    }

    public static DiscountType fromType(String source) {
        try {
            if (source.isEmpty()) {
                return NONE;
            }
            for (DiscountType type : DiscountType.values()) {
                if (type.isDiscountType(source)) {
                    return type;
                }
            }

            throw new IllegalArgumentException("Invalid discount type: " + source);
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new IllegalArgumentException("Invalid discount type: " + source);
        }
    }
}
