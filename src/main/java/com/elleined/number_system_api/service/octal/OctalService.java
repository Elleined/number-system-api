package com.elleined.number_system_api.service.octal;

public interface OctalService {
    <T, R> R toBinary(T t);
    <T, R> R toDecimal(T t);
    <T, R> R toHexaDecimal(T t);
}
