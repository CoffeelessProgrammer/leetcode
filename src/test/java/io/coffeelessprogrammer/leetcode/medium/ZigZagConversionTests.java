package io.coffeelessprogrammer.leetcode.medium;

import io.coffeelessprogrammer.leetcode.difficulty.medium.ZigZagConversion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZigZagConversionTests {

    @Test
    final void CompactOptimized_Rows2_WATEREARTHFIREAIR() {
        assertEquals("WTRATFRARAEERHIEI", ZigZagConversion.fmtHrzCompactOptimized("WATEREARTHFIREAIR", 2));
    }

    @Test
    final void CompactOptimized_Rows3_PAYPALISHIRING(){
        assertEquals("PAHNAPLSIIGYIR", ZigZagConversion.fmtHrzCompactOptimized("PAYPALISHIRING", 3));
    }

    @Test
    final void CompactOptimized_Rows4_WATEREARTHFIREAIR(){
        assertEquals("WARAERIETRTFAREHI", ZigZagConversion.fmtHrzCompactOptimized("WATEREARTHFIREAIR", 4));
    }

    @Test
    final void CompactOptimized_Rows5_WATEREARTHFIREAIR(){
        assertEquals("WTRARHITAFAEEIERR", ZigZagConversion.fmtHrzCompactOptimized("WATEREARTHFIREAIR", 5));
    }

    @Test
    final void Compact_Rows3_PAYPALISHIRING(){
        assertEquals("PAHNAPLSIIGYIR", ZigZagConversion.formatHorizontalCompact("PAYPALISHIRING", 3));
    }

    @Test
    final void Compact_Rows3_WATEREARTHFIREAIR(){
        assertEquals("WRTRRAEERHIEITAFA", ZigZagConversion.formatHorizontalCompact("WATEREARTHFIREAIR", 3));
    }

    @Test
    final void Compact_Rows4_WATEREARTHFIREAIR(){
        assertEquals("WARAERIETRTFAREHI", ZigZagConversion.formatHorizontalCompact("WATEREARTHFIREAIR", 4));
    }

    @Test
    final void Compact_Rows5_WATEREARTHFIREAIR(){
        assertEquals("WTRARHITAFAEEIERR", ZigZagConversion.formatHorizontalCompact("WATEREARTHFIREAIR", 5));
    }

    @Test
    final void Rows_3_PAYPALISHIRING(){
        final String zigzag =
                "P   A   H   N\n" +
                "A P L S I I G\n" +
                "Y   I   R";

        assertEquals(zigzag, ZigZagConversion.formatHorizontal("PAYPALISHIRING", 3));
    }

    @Test
    final void Rows_2_WATEREARTHFIREAIR() {
        final String zigzag =
                "W T R A T F R A R\n" +
                "A E E R H I E I";

        assertEquals(zigzag, ZigZagConversion.formatHorizontal("WATEREARTHFIREAIR", 2));
    }

    @Test
    final void Rows_3_WATEREARTHFIREAIR() {
        final String zigzag =
                "W   R   T   R   R\n" +
                "A E E R H I E I\n" +
                "T   A   F   A";

        assertEquals(zigzag, ZigZagConversion.formatHorizontal("WATEREARTHFIREAIR", 3));
    }

    @Test
    final void Rows_4_WATEREARTHFIREAIR() {
        final String zigzag =
                "W     A     R\n" +
                "A   E R   I E\n" +
                "T R   T F   A R\n" +
                "E     H     I";

        assertEquals(zigzag, ZigZagConversion.formatHorizontal("WATEREARTHFIREAIR", 4));
    }

    @Test
    final void Rows_5_WATEREARTHFIREAIR() {
        final String zigzag =
                "W       T       R\n" +
                "A     R H     I\n" +
                "T   A   F   A\n" +
                "E E     I E\n" +
                "R       R";

        assertEquals(zigzag, ZigZagConversion.formatHorizontal("WATEREARTHFIREAIR", 5));
    }
}
