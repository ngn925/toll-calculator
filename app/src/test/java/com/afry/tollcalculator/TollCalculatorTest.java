package com.afry.tollcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TollCalculatorTest {

    @Test
    void getTollFee() {
    }

    private static Stream<Arguments> provideDataForIsTollFree() {
        return Stream.of(
                Arguments.of("Car", false),
                Arguments.of("car", false),
                Arguments.of("Diplomat", true),
                Arguments.of("DIPLOMAT", true),
                Arguments.of("Foreign", true),
                Arguments.of("Emergency", true),
                Arguments.of("Military", true),
                Arguments.of("Motorbike", true),
                Arguments.of("Tractor", true),
                Arguments.of("", false),
                Arguments.of(null, false)
        );
    }
    @ParameterizedTest
    @MethodSource("provideDataForIsTollFree")
    void isTollFreeVehicle(String vehicleType, boolean expected) {
        // given
        TollCalculator tollCalculator = new TollCalculator();

        // when
        boolean tollFree = tollCalculator.isTollFreeVehicle(createVehicle(vehicleType));

        // then
        assertEquals(expected, tollFree);
    }

    @Test
    void testGetTollFee() {
    }

    private Vehicle createVehicle(final String type) {
        return new Vehicle() {
            @Override
            public String getType() {
                return type;
            }
        };
    }
}