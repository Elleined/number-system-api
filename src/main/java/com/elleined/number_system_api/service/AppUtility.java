package com.elleined.number_system_api.service;

import java.util.*;
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

    static List<Integer> toIntArray(int octal) {
        List<Integer> l = new ArrayList<>();
        for (Character c : String.valueOf(octal).toCharArray()) {
            l.add(Integer.parseInt(c.toString()));
        }
        return l;
    }

    // Before using this method make sure that the list your iterating is REVERSED!!! first
    static int getMultiplier(int index, Base base) {
        int multiplier = 1;
        while (index != 0) {
            multiplier *= base.getBase();
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

    static List<Integer> multiply(List<Integer> binaries, Base base) {
        List<Integer> products = new ArrayList<>();
        for (int i = 0; i < binaries.size(); i++) {
            int binary = binaries.get(i);
            if (binary == 0)
                continue;

            int multiplier = AppUtility.getMultiplier(i, base);
            products.add(binary * multiplier);
        }
        return products;
    }

    static String sum(List<Integer> integers) {
        return integers.stream()
                .reduce(0, Integer::sum)
                .toString();
    }

    static StringBuilder addZeros(String binary, int group) {
        final int remainder = binary.length() % group;

        final StringBuilder sb = new StringBuilder(binary);
        if (remainder != 0) {
            final int zerosToBeAdded = group - remainder;
            for (int i = 0; i < zerosToBeAdded; i++)
                sb.insert(0, "0");
        }
        return sb;
    }

    static String toHex(String decimal) {
        Map<String, String> map = new HashMap<>();
        map.put("0", "0");
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
        map.put("6", "6");
        map.put("7", "7");
        map.put("8", "8");
        map.put("9", "9");
        map.put("10", "A");
        map.put("11", "B");
        map.put("12", "C");
        map.put("13", "D");
        map.put("14", "E");
        map.put("15", "F");

        return map.get(decimal);
    }

    static int toHex(Character decimal) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put( 'A', 10);
        map.put( 'B', 11);
        map.put( 'C', 12);
        map.put( 'D', 13);
        map.put( 'E', 14);
        map.put( 'F', 15);

        return map.get(decimal);
    }

    static String toHex(int decimal) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(5, "5");
        map.put(6, "6");
        map.put(7, "7");
        map.put(8, "8");
        map.put(9, "9");
        map.put(10, "A");
        map.put(11, "B");
        map.put(12, "C");
        map.put(13, "D");
        map.put(14, "E");
        map.put(15, "F");

        return map.get(decimal);
    }
}
