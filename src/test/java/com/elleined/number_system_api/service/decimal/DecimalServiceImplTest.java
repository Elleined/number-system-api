package com.elleined.number_system_api.service.decimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DecimalServiceImplTest {

    @Test
    void toBinary() {
        // Pre defined values
        DecimalService decimalService = new DecimalServiceImpl();

        // Expected Value

        // Mock data

        // Set up method

        // Stubbing methods

        // Calling the method
        String binary = decimalService.toBinary(54);
        System.out.println("Binary value: " + binary);
        // Behavior Verifications

        // Assertions
        assertEquals("110110", binary);
    }

    @Test
    void toOctal() {
        // Pre defined values
        DecimalService decimalService = new DecimalServiceImpl();

        // Expected Value

        // Mock data

        // Set up method

        // Stubbing methods

        // Calling the method
        String octal = decimalService.toOctal(54);
        System.out.println("Octal value: " + octal);
        // Behavior Verifications

        // Assertions
        assertEquals("66", octal);
    }

    @Test
    void toHexaDecimal() {
        // Pre defined values
        DecimalService decimalService = new DecimalServiceImpl();
        // Expected Value

        // Mock data

        // Set up method

        // Stubbing methods

        // Calling the method
        String hexaDecimal = decimalService.toHexaDecimal(54);
        System.out.println("Hexadecimal value: " + hexaDecimal);

        // Behavior Verifications

        // Assertions
        assertEquals("36", hexaDecimal);
    }
}