package io.coffeelessprogrammer.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem: 13. Roman to Integer
 * Acceptance Rate: 57.6%
 * URL: https://leetcode.com/problems/roman-to-integer/
 *
 * Runtime: 3 ms, faster than 99.81% of Java online submissions for Roman to Integer.
 * Memory Usage: 38.6 MB, less than 99.60% of Java online submissions for Roman to Integer.
 */

public class RomanNumerals {

    private static Map<Character, Integer> romanToInt = new HashMap<>();

    static {
        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X', 10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);
    }

    public static int parseToInt(String romanNum) {
        int result = 0;

        boolean subtractPrevious = false;

        for(int i=0; i < romanNum.length(); ++i) {
            int val = romanToInt.get(romanNum.charAt(i));

            if(subtractPrevious) {
                result += val - romanToInt.get(romanNum.charAt(i-1));
                subtractPrevious = false;
                continue;
            }

            if(i+1 < romanNum.length() && val < romanToInt.get(romanNum.charAt(i+1))) {
                subtractPrevious = true;
            } else {
                result += val;
            }
        }

        return result;
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