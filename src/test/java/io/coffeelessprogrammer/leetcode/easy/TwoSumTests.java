package io.coffeelessprogrammer.leetcode.easy;

import io.coffeelessprogrammer.leetcode.difficulty.easy.TwoSum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoSumTests {

    @Test
    final void Case_1() {
        int[] result = TwoSum.twoSum(new int[]{11,2,15,7}, 9);
        assertEquals(1, result[0]);
        assertEquals(3, result[1]);
    }
}
