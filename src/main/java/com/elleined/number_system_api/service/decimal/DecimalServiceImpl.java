package com.elleined.number_system_api.service.decimal;

import com.elleined.number_system_api.service.AppUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class DecimalServiceImpl implements DecimalService {

    @Override
    public String toBinary(int decimal) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (decimal % 2 == 0)
                sb.append("0");
            else
                sb.append("1");

            if (decimal / 2 == 0)
                break;

            decimal /= 2;
        }

        sb.reverse();
        return AppUtility.sanitizeBinary(sb.toString());
    }

    @Override
    public String toOctal(int decimal) {
        StringBuilder sb = new StringBuilder();

        while (true) {
            int remainder = decimal % 8;
            sb.append(remainder);
            decimal /= 8;
            if (decimal <= 0)
                break;
        }

        sb.reverse();
        return AppUtility.sanitizeBinary(sb.toString());
    }

    @Override
    public String toHexaDecimal(int decimal) {
        StringBuilder sb = new StringBuilder();

        do {
            int remainder = decimal % 16;
            sb.append(AppUtility.toHex(remainder));

            decimal /= 16;
        } while (decimal > 0);

        sb.reverse();
        return AppUtility.sanitizeBinary(sb.toString());
    }
}
