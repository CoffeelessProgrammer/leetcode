package io.coffeelessprogrammer.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RichestCustomerWealthTests {

    private int[][] balances1 = new int[][]{{1,5},{7,3},{3,5}};

    private int[][] balances2 = new int[][]{{2,8,7},{7,1,3},{1,9,5}};

    @Test
    final void Case1() {
        assertEquals(10, RichestCustomerWealth.calculate(balances1));
    }

    @Test
    final void Case2() {
        assertEquals(17, RichestCustomerWealth.calculate(balances2));
    }
}
