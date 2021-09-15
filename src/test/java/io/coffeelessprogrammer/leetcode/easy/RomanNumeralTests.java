package io.coffeelessprogrammer.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralTests {

    @Test
    final void XVII_17() {
        assertEquals(17, RomanNumerals.parseToInt("XVII"));
    }

    @Test
    final void XLII_42() {
        assertEquals(42, RomanNumerals.parseToInt("XLII"));
    }

    @Test
    final void XCIX_99() {
        assertEquals(99, RomanNumerals.parseToInt("XCIX"));
    }

    @Test
    final void MMCDLXVIII_2468() {
        assertEquals(2468, RomanNumerals.parseToInt("MMCDLXVIII"));
    }
}
