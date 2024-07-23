package com.elleined.number_system_api.service.binary.utils;

import com.elleined.number_system_api.service.binary.BinaryService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public interface ToOctalUtility {

    static StringBuilder addZeros(String binary) {
        final int grouper = 3;
        final int remainder = binary.length() % grouper;

        final StringBuilder sb = new StringBuilder(binary);
        if (remainder != 0) {
            final int zerosToBeAdded = grouper - remainder;
            for (int i = 0; i < zerosToBeAdded; i++)
                sb.insert(0, "0");
        }
        return sb;
    }

    static Stream<List<Integer>> groupIntoThrees(StringBuilder input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            result.append(input.charAt(i));
            if ((i + 1) % 3 == 0 && i != input.length() - 1)
                result.append(' ');
        }

        return Arrays.stream(result.toString()
                .split(" "))
                .map(BinaryService::toIntArray);
    }

    // index 0 = 4
    // index 1 = 2
    // index 2 = 1
    static List<Integer> multiply(List<Integer> integers) {
        List<Integer> computedIntegers = new ArrayList<>();
        for (int index = 0; index < integers.size(); index++) {
            int binary = integers.get(index);
            if (binary == 0)
                continue;

            int computedInteger = switch (index) {
                case 0 -> binary * 4;
                case 1 -> binary * 2;
                case 2 -> binary;
                default -> throw new IllegalStateException("Unexpected value: " + integers.get(index));
            };
            computedIntegers.add(computedInteger);
        }
        return computedIntegers;
    }

    static String sum(List<Integer> integers) {
        return integers.stream()
                .reduce(0, Integer::sum)
                .toString();
    }
}
