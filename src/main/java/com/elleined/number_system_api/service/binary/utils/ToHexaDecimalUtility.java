package com.elleined.number_system_api.service.binary.utils;

public interface ToHexaDecimalUtility {

    static String toHex(String binary) {
        return Integer.toHexString(Integer.parseInt(binary));
    }
}
