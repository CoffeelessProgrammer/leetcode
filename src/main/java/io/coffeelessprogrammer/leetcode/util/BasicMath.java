package io.coffeelessprogrammer.leetcode.util;

public class BasicMath {

    public static int leastCommonMultiple(final int m, final int n) {
        final int larger = Math.max(m, n);
        final int smaller = Math.min(m, n);

        int leastCommonMultiple = larger;

        while(leastCommonMultiple % smaller != 0) {
            leastCommonMultiple += larger;
        }

        return leastCommonMultiple;
    }
}
