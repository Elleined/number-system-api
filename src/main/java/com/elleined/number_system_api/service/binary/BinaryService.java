package com.elleined.number_system_api.service.binary;

public interface BinaryService {
    <T, R> R toOctal(T t);
    <T, R> R toDecimal(T t);
    <T, R> R toHexaDecimal(T t);
}
