package com.elleined.number_system_api.service.binary;

import com.elleined.number_system_api.service.binary.utils.ToOctalUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Stream;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class BinaryServiceImpl implements BinaryService {

    /**
     * 1. Group the binary number into (3) three's
     *    Note: Grouping of binary must be done by <----- direction.
     *    Note: If the binary length is not divisible by three. we just add zero's to make it three's
     *          Example: We have 1110010 7 digits binary after grouping it will be 001 110 010 notice that we add additional zero's here
     * 2. Multiply each group by 1, 2, 4, 8, 16, and so on...
     *    Note: that all number that are match to 0 will not be included in the multiplying process. Why? because 0 x n is equal to 0 zero right? make sense?
     * 3. After multiplying add the product of each number by group
     * 4. Merge the sum of all groups.
     * Example:
     * 110010
     *
     * 110 010 // Step 1
     *
     *   1 1 0 | 1 0 1 // Step 2
     *   x x x | x x x
     *   4 2 1 | 4 2 1 // Step 2
     *   ------------
     * = 4 2 0 | 4 0 1 // Step 3
     *   4 + 2 + 0  | 4 + 0 + 1 // Step 3
     *   ----------------------
     * = 6 | 5 // Step 3
     * = 65 octal // Step 4
     *
     * @param binary
     * @return
     */
    @Override
    public String toOctal(final String binary) {
        StringBuilder sb = ToOctalUtility.addZeros(binary); // Step 1

        return ToOctalUtility.groupIntoThrees(sb) // Step 1
                .map(ToOctalUtility::multiply) // Step 2
                .map(ToOctalUtility::sum) // Step 3
                .reduce("", String::concat);// Step 4
    }
}