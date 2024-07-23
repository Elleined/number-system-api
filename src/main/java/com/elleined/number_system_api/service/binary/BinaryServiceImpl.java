package com.elleined.number_system_api.service.binary;

import com.elleined.number_system_api.service.binary.utils.ToDecimalUtility;
import com.elleined.number_system_api.service.binary.utils.ToOctalUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class BinaryServiceImpl implements BinaryService {

    @Override
    public String toOctal(final String binary) {
        final String sanitizedBinary = BinaryService.sanitizeBinary(binary);

        StringBuilder sb = ToOctalUtility.addZeros(sanitizedBinary); // Step 1
        return ToOctalUtility.groupIntoThrees(sb) // Step 1
                .map(ToOctalUtility::multiply) // Step 2
                .map(ToOctalUtility::sum) // Step 3
                .reduce("", String::concat);// Step 4
    }

    @Override
    public String toDecimal(final String binary) {
        final String sanitizedBinary = BinaryService.sanitizeBinary(binary);

        List<Integer> binaries = BinaryService.toIntArray(sanitizedBinary).reversed();
        final List<Integer> products = new ArrayList<>();
        for (int i = 0; i < binaries.size(); i++) {
            int rawBinary = binaries.get(i);
            if (rawBinary == 0)
                continue;

            int multiplier = ToDecimalUtility.getMultiplier(i);
            int product = rawBinary * multiplier;
            products.add(product);
        }

        return products.stream()
                .reduce(0, Integer::sum)
                .toString();
    }
}
