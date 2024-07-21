package com.elleined.number_system_api.service.decimal;

public interface DecimalService {
    <T, R> R toBinary(T t);
    <T, R> R toOctal(T t);
    <T, R> R toHexaDecimal(T t);
}
