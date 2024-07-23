package com.elleined.number_system_api.service.binary;

public interface BinaryService {
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
    String toOctal(String binary);


    /**
     * 1. Ignore all zero's
     *      Note: The multiplier will be 1, 2, 4, 8, and so on.
     *            Where the number is the last number plus itself.
     *            So based on the example 8 is last the next number will be 16, 32, 64, and so on.
     *
     *      Note: And if there are decimal places in the binary example 101.01
     *            just like before ignore all zeros and the multiplier for the decimals is 1/n where n is the corresponding multiplier value in the whole binary number. So for my example. It will be
     *            2^2 = 4     2^1 = 2      2^0 = 1            2^-1 = 1/2      2^-2 = 1/4
     *            1           0            1           .      0               1
     *
     *              Notice the 2^2 is 4 right and whenever a decimal place is in 2^-2 it will be 1/4
     *            we just make them fractional as 1 as its on top.
     * @param binary
     * @return
     */
    String toDecimal(String binary);

    static String sanitizeBinary(String binary) {
        return binary.trim().strip().replaceAll(" ", "");
    }
}
