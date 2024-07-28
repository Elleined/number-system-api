package com.elleined.number_system_api.controller;

import com.elleined.number_system_api.dto.NumberSystemDTO;
import com.elleined.number_system_api.service.decimal.DecimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/decimal")
@RequiredArgsConstructor
public class DecimalController {
    private final DecimalService decimalService;

    @PostMapping
    public NumberSystemDTO decimal(@RequestParam("decimal") int decimal) {
        String binary = decimalService.toBinary(decimal);
        String octal = decimalService.toOctal(decimal);
        String hexaDecimal = decimalService.toHexaDecimal(decimal);

        return NumberSystemDTO.builder()
                .binary(binary)
                .octal(octal)
                .decimal(String.valueOf(decimal))
                .hexaDecimal(hexaDecimal)
                .build();
    }
}
