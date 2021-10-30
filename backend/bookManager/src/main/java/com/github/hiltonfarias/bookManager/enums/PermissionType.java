package com.github.hiltonfarias.bookManager.enums;

public enum PermissionType {
    USER("ROLE_USER"), ADMIN("ROLE_ADMIN");
    private final String code;

    private PermissionType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
