package com.elleined.number_system_api.service.hexa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.elleined.number_system_api.service.binary.BinaryServiceImpl;
import com.elleined.number_system_api.service.decimal.DecimalServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class HexaDecimalServiceImplTest {

    @Test
    void toBinary() {
        // Pre defined values
        HexaDecimalService hexaDecimalService = new HexaDecimalServiceImpl(new DecimalServiceImpl(), new BinaryServiceImpl());

        // Expected Value

        // Mock data

        // Set up method

        // Stubbing methods

        // Calling the method
        String hexaDecimal = hexaDecimalService.toBinary("5E");
        System.out.println("Hexadecimal value: " + hexaDecimal);
        // Behavior Verifications

        // Assertions
        assertEquals("01011110", hexaDecimal);
    }

    @Test
    void toOctal() {
        // Pre defined values
        HexaDecimalService hexaDecimalService = new HexaDecimalServiceImpl(new DecimalServiceImpl(), new BinaryServiceImpl());

        // Expected Value

        // Mock data

        // Set up method

        // Stubbing methods

        // Calling the method
        String hexaDecimal = hexaDecimalService.toOctal("5E");
        System.out.println("Hexadecimal value: " + hexaDecimal);
        // Behavior Verifications

        // Assertions
        assertEquals("136", hexaDecimal);
    }

    @Test
    void toDecimal() {
        // Pre defined values
        HexaDecimalService hexaDecimalService = new HexaDecimalServiceImpl(new DecimalServiceImpl(), new BinaryServiceImpl());

        // Expected Value

        // Mock data

        // Set up method

        // Stubbing methods

        // Calling the method
        String hexaDecimal = hexaDecimalService.toDecimal("5E");
        System.out.println("Hexadecimal value: " + hexaDecimal);
        // Behavior Verifications

        // Assertions
        assertEquals("94", hexaDecimal);
    }
}