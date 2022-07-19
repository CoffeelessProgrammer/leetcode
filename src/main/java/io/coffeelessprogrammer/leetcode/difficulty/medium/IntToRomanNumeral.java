package io.coffeelessprogrammer.leetcode.difficulty.medium;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem: 12. Integer to Roman
 * Acceptance Rate: 58.2%
 * URL: https://leetcode.com/problems/integer-to-roman/
 *
 * Runtime: 4 ms, faster than 81.17% of Java online submissions for Integer to Roman.
 * Memory Usage: 38.7 MB, less than 68.32% of Java online submissions for Integer to Roman.
 */

public class IntToRomanNumeral {

    private static final Map<Integer, String> intToRoman = new HashMap<>();

    static {
        intToRoman.put(1, "I");
        intToRoman.put(4, "IV");
        intToRoman.put(5, "V");
        intToRoman.put(9, "IX");
        intToRoman.put(10, "X");
        intToRoman.put(40, "XL");
        intToRoman.put(50, "L");
        intToRoman.put(90, "XC");
        intToRoman.put(100, "C");
        intToRoman.put(400, "CD");
        intToRoman.put(500, "D");
        intToRoman.put(900, "CM");
        intToRoman.put(1000, "M");
    }

    private static final int[] romanDescending = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};


    public static String convert(int number) {
        int[] multipleCount = new int[romanDescending.length];
        boolean[] isMultiplePresent = new boolean[romanDescending.length];

        for(int i=0; number > 0; ++i) {
            multipleCount[i] = number/romanDescending[i];
            isMultiplePresent[i] = multipleCount[i] > 0;
            number -= romanDescending[i] * multipleCount[i];
        }

        StringBuilder romanNumeral = new StringBuilder();

        for(int i=0; i < multipleCount.length; ++i) {
            if(!isMultiplePresent[i]) continue;

            romanNumeral.append(
                    intToRoman.get(romanDescending[i]).repeat(multipleCount[i])
            );
        }

        return romanNumeral.toString();
    }
}

/*
    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
 */