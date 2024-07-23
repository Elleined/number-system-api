package com.elleined.number_system_api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public interface AppUtility {
    static String sanitizeBinary(String binary) {
        return binary.trim().strip().replaceAll(" ", "");
    }

    static List<Integer> toIntArray(String binary) {
        List<Integer> l = new ArrayList<>();
        for (Character c : binary.toCharArray()) {
            l.add(Integer.parseInt(c.toString()));
        }
        return l.reversed();
    }

    // Before using this method make sure that the list your iterating is REVERSED!!! first
    static int getMultiplier(int index) {
        int multiplier = 1;
        while (index != 0) {
            multiplier *= 2;
            index--;
        }

        return multiplier;
    }

    static Stream<String> group(StringBuilder input, int numberPerGroup) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            result.append(input.charAt(i));
            if ((i + 1) % numberPerGroup == 0 && i != input.length() - 1)
                result.append(' ');
        }

        return Arrays.stream(result.toString().split(" "));
    }

    static List<Integer> multiply(List<Integer> binaries) {
        List<Integer> products = new ArrayList<>();
        for (int i = 0; i < binaries.size(); i++) {
            int binary = binaries.get(i);
            if (binary == 0)
                continue;

            int multiplier = AppUtility.getMultiplier(i);
            products.add(binary * multiplier);
        }
        return products;
    }

    static String sum(List<Integer> integers) {
        return integers.stream()
                .reduce(0, Integer::sum)
                .toString();
    }

}
