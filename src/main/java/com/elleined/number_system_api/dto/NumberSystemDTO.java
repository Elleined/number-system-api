package com.elleined.number_system_api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NumberSystemDTO {
    private String binary;
    private String octal;
    private String decimal;
    private String hexaDecimal;
}
