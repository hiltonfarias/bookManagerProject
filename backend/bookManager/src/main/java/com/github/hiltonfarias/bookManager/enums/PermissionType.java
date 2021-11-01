package com.github.hiltonfarias.bookManager.enums;

public enum PermissionType {
    USER("ROLE_USE"), ADMIN("ROLE_ADM");
    private final String code;

    private PermissionType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
