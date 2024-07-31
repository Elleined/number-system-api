package com.elleined.number_system_api.service.octal;

import com.elleined.number_system_api.service.AppUtility;
import com.elleined.number_system_api.service.Base;
import com.elleined.number_system_api.service.binary.BinaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class OctalServiceImpl implements OctalService {
    private final BinaryService binaryService;

    @Override
    public String toBinary(int octal) {
        List<Integer> octals = AppUtility.toIntArray(octal);

        return octals.stream()
                .map(o -> toBinaryConvertionTable().get(o))
                .reduce("", (t, s) -> t + s);
    }

    @Override
    public String toDecimal(int octal) {
        List<Integer> octals = AppUtility.toIntArray(octal).reversed();
        List<Integer> products = AppUtility.multiply(octals, Base.OCTAL);
        return AppUtility.sum(products);
    }

    @Override
    public String toHexaDecimal(int octal) {
        final int group = 4;
        StringBuilder sb = AppUtility.addZeros(toBinary(octal), group);
        return AppUtility.group(sb, group)
                .map(binaryService::toDecimal)
                .map(AppUtility::toHex)
                .map(String::toUpperCase)
                .reduce("", String::concat);
    }

    private Map<Integer, String> toBinaryConvertionTable() {
        return Map.of(
                0, "000",
                1, "001",
                2, "010",
                3, "011",
                4, "100",
                5, "101",
                6, "110",
                7, "111"
        );
    }
}
