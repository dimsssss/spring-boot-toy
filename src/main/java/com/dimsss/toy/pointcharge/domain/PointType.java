package com.dimsss.toy.pointcharge.domain;

import lombok.Getter;

@Getter
public enum PointType {
    NONE("none");

    private final String type;


    PointType(String type) {
        this.type = type;
    }

    public static PointType of(String source) {
        return NONE;
    }

    private boolean isPointType(String source) {
        return this.getType().equalsIgnoreCase(source);
    }


    public static PointType fromType(String source) {
        try {
            if (source.isEmpty()) {
                return NONE;
            }
            for (PointType type : PointType.values()) {
                if (type.isPointType(source)) {
                    return type;
                }
            }

            throw new IllegalArgumentException("Invalid point type: " + source);
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new IllegalArgumentException("Invalid point type: " + source);
        }
    }
}
