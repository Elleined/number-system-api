package com.elleined.number_system_api.service.octal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.elleined.number_system_api.service.binary.BinaryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OctalServiceImplTest {

    @Test
    void toBinary() {
        // Pre defined values
        OctalService octalService = new OctalServiceImpl(new BinaryServiceImpl());

        // Expected Value

        // Mock data

        // Set up method

        // Stubbing methods

        // Calling the method
        String binary = octalService.toBinary(56);
        System.out.println("Binary value: " + binary);

        // Behavior Verifications

        // Assertions
        assertEquals("101110", binary);
    }

    @Test
    void toDecimal() {
        // Pre defined values
        OctalService octalService = new OctalServiceImpl(new BinaryServiceImpl());
        // Expected Value

        // Mock data

        // Set up method

        // Stubbing methods

        // Calling the method
        String decimal = octalService.toDecimal(56);
        System.out.println("Decimal value: " + decimal);

        // Behavior Verifications

        // Assertions
        assertEquals("46", decimal);
    }

    @Test
    void toHexaDecimal() {
        // Pre defined values
        OctalService octalService = new OctalServiceImpl(new BinaryServiceImpl());

        // Expected Value

        // Mock data

        // Set up method

        // Stubbing methods

        // Calling the method
        String hexaDecimal = octalService.toHexaDecimal(56);
        System.out.println("HexaDecimal value: " + hexaDecimal);

        // Behavior Verifications

        // Assertions
        assertEquals("2E", hexaDecimal);
    }
}