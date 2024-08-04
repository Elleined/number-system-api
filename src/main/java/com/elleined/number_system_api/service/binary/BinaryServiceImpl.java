package com.elleined.number_system_api.service.binary;

import com.elleined.number_system_api.service.AppUtility;
import com.elleined.number_system_api.service.Base;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class BinaryServiceImpl implements BinaryService {

    @Override
    public String toOctal(final String binary) {
        final int group = 3;
        final String sanitizedBinary = AppUtility.sanitizeBinary(binary);

        StringBuilder sb = AppUtility.addZeros(sanitizedBinary, group); // Step 1
        return AppUtility.group(sb, group) // Step 1
                .map(AppUtility::toIntArray) // Set up method
                .map(integers -> AppUtility.multiply(integers, Base.BINARY)) // Step 2
                .map(AppUtility::sum) // Step 3
                .reduce("", String::concat); // Step 4
    }

    @Override
    public String toDecimal(final String binary) {
        final String sanitizedBinary = AppUtility.sanitizeBinary(binary);

        List<Integer> binaries = AppUtility.toIntArray(sanitizedBinary);
        List<Integer> computedBinaries = AppUtility.multiply(binaries, Base.BINARY);
        computedBinaries.forEach(System.out::println);
        return AppUtility.sum(computedBinaries);
    }

    @Override
    public String toHexaDecimal(String binary) {
        final int group = 4;
        final String sanitizedBinary = AppUtility.sanitizeBinary(binary);

        StringBuilder sb = AppUtility.addZeros(sanitizedBinary, group); // Step 1
        return AppUtility.group(sb, group)
                .map(AppUtility::toIntArray)
                .map(integers -> AppUtility.multiply(integers, Base.BINARY))
                .map(AppUtility::sum)
                .map(AppUtility::toHex)
                .reduce("", String::concat);
    }
}
