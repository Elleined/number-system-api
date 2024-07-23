package com.elleined.number_system_api.service.binary.utils;

public interface ToOctalUtility {

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
}
