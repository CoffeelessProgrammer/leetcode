package io.coffeelessprogrammer.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.coffeelessprogrammer.leetcode.twopointers.ContainerWithMostWater;

public class ContainerWithMostWaterTests {

    @Test
    final void Case_Happy() {
        Assertions.assertEquals(28, ContainerWithMostWater.calcMaxArea(new int[]{7, 1, 2, 3, 9}));
    }

    @Test
    final void Case_Edge() {
        Assertions.assertEquals(0, ContainerWithMostWater.calcMaxArea(new int[]{5}));
    }

    @Test
    final void Case_Tricky() {
        Assertions.assertEquals(32, ContainerWithMostWater.calcMaxArea(new int[]{6, 9, 3, 4, 5, 8}));
    }

    @Test
    final void Case_Tricky_2() {
        Assertions.assertEquals(49, ContainerWithMostWater.calcMaxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    @Test
    final void Case_Tricky_3() {
        Assertions.assertEquals(304590, ContainerWithMostWater.calcMaxArea(new int[]{8361,
                5302,
                8672,
                2400,
                5150,
                3527,
                9216,
                6713,
                2902,
                310,
                555,
                9176,
                311,
                9968,
                5705,
                3983,
                7992,
                8553,
                6953,
                9541,
                5828,
                1750,
                6731,
                3552,
                5274,
                7303,
                3724,
                5387,
                9504,
                1900,
                937,
                1146,
                7266,
                7943,
                7911,
                9055,
                8046,
                7180,
                6516,
                7810,
                686,
                5210,
                1956}));
    }
}
