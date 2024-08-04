package com.elleined.number_system_api.controller;

import com.elleined.number_system_api.dto.NumberSystemDTO;
import com.elleined.number_system_api.service.hexa.HexaDecimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hexadecimal")
@RequiredArgsConstructor
public class HexaDecimalController {
    private final HexaDecimalService hexaDecimalService;

    @GetMapping
    public NumberSystemDTO decimal(@RequestParam("hexaDecimal") String hexaDecimal) {
        String binary = hexaDecimalService.toBinary(hexaDecimal);
        String octal = hexaDecimalService.toOctal(hexaDecimal);
        String decimal = hexaDecimalService.toDecimal(hexaDecimal);

        return NumberSystemDTO.builder()
                .binary(binary)
                .octal(octal)
                .decimal(decimal)
                .hexaDecimal(hexaDecimal)
                .build();
    }
}
