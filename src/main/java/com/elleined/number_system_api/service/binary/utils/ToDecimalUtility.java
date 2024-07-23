package com.elleined.number_system_api.service.binary.utils;

import java.util.ArrayList;
import java.util.List;

public interface ToDecimalUtility {

    static int getMultiplier(int index) {
        int multiplier = 1;
        while (index != 0) {
            multiplier *= 2;
            index--;
        }

        return multiplier;
    }
}
