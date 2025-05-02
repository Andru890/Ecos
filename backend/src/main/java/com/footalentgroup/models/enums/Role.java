package com.footalentgroup.models.enums;

public enum Role {
    FAN, MUSICIAN, ORGANIZER;

    public static final String PREFIX = "ROLE_";

    public static Role of(String withPrefix) {
        return Role.valueOf(withPrefix.replace(Role.PREFIX, ""));
    }
}
