package io.coffeelessprogrammer.leetcode;

import io.coffeelessprogrammer.leetcode.easy.RomanNumeralToInt;
import io.coffeelessprogrammer.leetcode.medium.IntToRomanNumeral;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralTests {

    // #region RomanNumeralToInteger

    @Test
    final void RomanToInt_XVII_17() {
        assertEquals(17, RomanNumeralToInt.convert("XVII"));
    }

    @Test
    final void RomanToInt_XLII_42() {
        assertEquals(42, RomanNumeralToInt.convert("XLII"));
    }

    @Test
    final void RomanToInt_XCIX_99() {
        assertEquals(99, RomanNumeralToInt.convert("XCIX"));
    }

    @Test
    final void RomanToInt_MMCDLXVIII_2468() {
        assertEquals(2468, RomanNumeralToInt.convert("MMCDLXVIII"));
    }

    // #endRegion

    // #region IntegerToRomanNumeral

    @Test
    final void IntToRoman_58_LVIII() {
        assertEquals("LVIII", IntToRomanNumeral.convert(58));
    }

    @Test
    final void IntToRoman_1994_MCMXCIV() {
        assertEquals("MCMXCIV", IntToRomanNumeral.convert(1994));
    }

    // #endRegion
}
