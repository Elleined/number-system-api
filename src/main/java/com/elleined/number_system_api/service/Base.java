package com.elleined.number_system_api.service;

import lombok.Getter;

@Getter
public enum Base {
    BINARY(2),
    OCTAL(8),
    DECIMAL(10),
    HEXA_DECIMAL(16);

    private final int base;

    Base(int base) {
        this.base = base;
    }
}
