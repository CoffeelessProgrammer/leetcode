package io.coffeelessprogrammer.leetcode.easy;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReverseIntegerTests {

    @Test
    final void Positive_3_Digit() {
        assertEquals(258, ReverseInteger.reverse(852));
    }

    @Test
    final void Negative_3_Digit() {
        assertEquals(-945, ReverseInteger.reverse(-549));
    }

    @Test
    final void Positive_10_Digit() {
        assertEquals(1_513_515_421, ReverseInteger.reverse(1_245_153_151));
    }

    @Test
    final void Positive_Overflow() {
        assertEquals(0, ReverseInteger.reverse(1_712_515_463));
    }

    @Test
    final void Positive_DoubleOverflow() {
        assertEquals(0, ReverseInteger.reverse(1_534_236_469));
    }

    // #region HelperTests

    @Test
    @Disabled
    final void DetectOverflow_PositiveInteger(){
        assertTrue(ReverseInteger.isOverflowDetected(1_712_515_463));
    }

    @Test
    @Disabled
    final void Count3Digits() {
        assertEquals(3, ReverseInteger.countDigits(534));
    }

    @Test
    @Disabled
    final void Count10Digits() {
        assertEquals(10, ReverseInteger.countDigits(1_534_236_469));
    }

    // #endRegion
}
