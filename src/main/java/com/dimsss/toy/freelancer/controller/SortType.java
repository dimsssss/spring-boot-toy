package com.dimsss.toy.freelancer.controller;

import lombok.Getter;

@Getter
public enum SortType {
    NAME_ASC("name", "asc"),
    NAME_DESC("name", "desc"),
    VIEW_COUNT_ASC("viewCount", "asc"),
    VIEW_COUNT_DESC("viewCount", "desc"),
    CREATED_AT_ASC("createdAt", "asc"),
    CREATED_AT_DESC("createdAt", "desc");

    private final String field;
    private final String direction;


    SortType(String field, String direction) {
        this.field = field;
        this.direction = direction;
    }

    public String getField() {
        return field;
    }

    public String getDirection() {
        return direction;
    }

    private boolean isSortType(String field, String direction) {
        return this.getField().equalsIgnoreCase(field) && this.getDirection().equalsIgnoreCase(direction);
    }

    public static SortType fromField(String source) {
        try {
            String[] result  = source.split(",");
            String field = result[0];
            String direction = result[1];

            for (SortType type : SortType.values()) {
                if (type.isSortType(field, direction)) {
                    return type;
                }
            }

            throw new IllegalArgumentException("Invalid sort type: " + field + " " + direction);
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new IllegalArgumentException("Invalid sort type: " + source);
        }
    }
}

