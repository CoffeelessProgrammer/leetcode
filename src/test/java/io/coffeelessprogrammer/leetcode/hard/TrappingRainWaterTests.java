package io.coffeelessprogrammer.leetcode.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrappingRainWaterTests {

    @Test
    final void HappyPath_RockClimbing() {
        Assertions.assertEquals(4, TrappingRainWater.calcVolume(new int[]{0, 1, 0, 2, 1, 0, 3,}));
    }

    @Test
    final void HappyPath_Skiing() {
        Assertions.assertEquals(4, TrappingRainWater.calcVolume(new int[]{3, 0, 1, 2, 0, 1, 0,}));
    }

    @Test
    final void HappyPath_Mountain() {
        Assertions.assertEquals(8, TrappingRainWater.calcVolume(new int[]{0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2}));
    }
}
