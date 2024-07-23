package com.elleined.number_system_api.service.binary.utils;

import java.util.ArrayList;
import java.util.List;

public interface ToOctalUtility {

    // Step 1 method
    static String sanitizedBinary(String binary) {
        return binary.trim().strip().replaceAll(" ", "");
    }

    // Step 2 method
    static String[] groupIntoThrees(StringBuilder input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            result.append(input.charAt(i));
            if ((i + 1) % 3 == 0 && i != input.length() - 1)
                result.append(' ');
        }

        return result.toString()
                .split(" ");
    }

    // Step 2 method
    static List<Integer> convert(char[] chars) {
        List<Integer> list = new ArrayList<>();
        for (Character c : chars) {
            list.add(Integer.parseInt(c.toString()));
        }
        return list;
    }

    // Step 2 method
    static List<Integer> compute(List<Integer> ints) {
        // index 0 = 4
        // index 1 = 2
        // index 2 = 1
        List<Integer> computedInts = new ArrayList<>();
        for (int i = 0; i < ints.size(); i++) {
            if (ints.get(i) == 0)
                continue;

            if (i == 0) {
                int computed = ints.get(i) * 4;
                computedInts.add(computed);
            } else if (i == 1) {
                int computed = ints.get(i) * 2;
                computedInts.add(computed);
            } else if (i == 2) {
                int computed = ints.get(i);
                computedInts.add(computed);
            }
        }

        return computedInts;
    }

    static int add(List<Integer> integers) {
        return integers.stream()
                .reduce(0, Integer::sum);
    }
}
