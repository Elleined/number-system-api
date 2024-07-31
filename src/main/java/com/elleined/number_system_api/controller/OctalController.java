package com.elleined.number_system_api.controller;

import com.elleined.number_system_api.dto.NumberSystemDTO;
import com.elleined.number_system_api.service.octal.OctalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/octal")
@RequiredArgsConstructor
public class OctalController {
    private final OctalService octalService;

    @GetMapping
    public NumberSystemDTO decimal(@RequestParam("octal") int octal) {
        String binary = octalService.toBinary(octal);
        String decimal = octalService.toDecimal(octal);
        String hexaDecimal = octalService.toHexaDecimal(octal);

        return NumberSystemDTO.builder()
                .binary(binary)
                .octal(String.valueOf(octal))
                .decimal(decimal)
                .hexaDecimal(hexaDecimal)
                .build();
    }
}
