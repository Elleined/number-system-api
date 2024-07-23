package com.elleined.number_system_api.service.binary;

import com.elleined.number_system_api.service.binary.utils.ToOctalUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class BinaryServiceImpl implements BinaryService {

    @Override
    public String toOctal(final String binary) {
        StringBuilder sb = ToOctalUtility.addZeros(binary); // Step 1

        return ToOctalUtility.groupIntoThrees(sb) // Step 1
                .map(ToOctalUtility::multiply) // Step 2
                .map(ToOctalUtility::sum) // Step 3
                .reduce("", String::concat);// Step 4
    }

    @Override
    public String toDecimal(String binary) {

        return "";
    }
}
