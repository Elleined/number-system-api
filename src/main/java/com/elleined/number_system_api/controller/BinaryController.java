package com.elleined.number_system_api.controller;

import com.elleined.number_system_api.dto.NumberSystemDTO;
import com.elleined.number_system_api.service.binary.BinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/binary")
@RequiredArgsConstructor
public class BinaryController {
    private final BinaryService binaryService;

    @GetMapping
    public NumberSystemDTO binary(@RequestParam("binary") String binary) {
        String octal = binaryService.toOctal(binary);
        String decimal = binaryService.toDecimal(binary);
        String hexaDecimal = binaryService.toHexaDecimal(binary);

        return NumberSystemDTO.builder()
                .binary(binary)
                .octal(octal)
                .decimal(decimal)
                .hexaDecimal(hexaDecimal)
                .build();
    }
}
