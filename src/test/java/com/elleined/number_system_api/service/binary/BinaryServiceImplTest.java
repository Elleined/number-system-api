package com.elleined.number_system_api.service.binary;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BinaryServiceImplTest {

    @Test
    void toOctal() {
        // Pre defined values
        BinaryService binaryService = new BinaryServiceImpl();

        // Expected Value

        // Mock data

        // Set up method

        // Stubbing methods

        // Calling the method
        String octal = binaryService.toOctal(" 1 110 010  ");
        System.out.println("Octal value: " + octal);

        // Behavior Verifications

        // Assertions
    }

    @Test
    void toDecimal() {
        // Pre defined values
        BinaryService binaryService = new BinaryServiceImpl();

        // Expected Value

        // Mock data

        // Set up method

        // Stubbing methods

        // Calling the method
        String decimal = binaryService.toDecimal(" 1 110 010  ");
        System.out.println("Decimal value: " + decimal);
        // Behavior Verifications

        // Assertions
    }
}