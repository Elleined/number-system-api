package com.elleined.number_system_api.service.hexa;

public interface HexaDecimalService {
    <T, R> R toBinary(T t);
    <T, R> R toOctal(T t);
    <T, R> R toDecimal(T t);
}
