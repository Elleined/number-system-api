package com.elleined.number_system_api.service.hexa;

import com.elleined.number_system_api.service.AppUtility;
import com.elleined.number_system_api.service.Base;
import com.elleined.number_system_api.service.binary.BinaryService;
import com.elleined.number_system_api.service.decimal.DecimalService;
import com.elleined.number_system_api.service.octal.OctalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class HexaDecimalServiceImpl implements HexaDecimalService {
    private final DecimalService decimalService;
    private final BinaryService binaryService;

    @Override
    public String toBinary(String hexaDecimal) {
        List<Integer> decimal = new ArrayList<>();
        for (Character character : hexaDecimal.toCharArray()) {
            decimal.add(AppUtility.toHex(character));
        }

        return decimal.stream()
                .map(decimalService::toBinary)
                .map(binary -> AppUtility.addZeros(binary, 4))
                .map(StringBuilder::toString)
                .reduce("", String::concat);
    }

    @Override
    public String toOctal(String hexaDecimal) {
        List<Integer> decimal = new ArrayList<>();
        for (Character character : hexaDecimal.toCharArray()) {
            decimal.add(AppUtility.toHex(character));
        }

        String binary = decimal.stream()
                .map(decimalService::toBinary)
                .reduce("", String::concat);

        return binaryService.toOctal(binary);
    }

    @Override
    public String toDecimal(String hexaDecimal) {
        List<Integer> decimal = new ArrayList<>();
        for (Character character : hexaDecimal.toCharArray()) {
            decimal.add(AppUtility.toHex(character));
        }

        return AppUtility.multiply(decimal.reversed(), Base.HEXA_DECIMAL).stream()
                .reduce(0, Integer::sum)
                .toString();
    }
}
