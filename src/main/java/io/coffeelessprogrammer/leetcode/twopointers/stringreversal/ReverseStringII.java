package io.coffeelessprogrammer.leetcode.twopointers.stringreversal;

import io.coffeelessprogrammer.leetcode.utility.Array;

/*
 * Problem: 541. Reverse String II
 * Difficulty: Easy
 * Acceptance Rate: 50.2%
 * URL: https://leetcode.com/problems/reverse-string-ii/
 *
 * Runtime: 2 ms, faster than 65.15% of Java online submissions for Reverse String II.
 * Memory Usage: 43.6 MB, less than 76.19% of Java online submissions for Reverse String II.
 */
public class ReverseStringII {

    public static String reverse(String s, int k) {
        char[] arr = s.toCharArray();

        for(int i=0; i < arr.length; i += 2*k) {
            if(i+k < arr.length)
                Array.reverseSegment(arr, i, i+k-1);
            else if(i+k >= arr.length)
                Array.reverseSegment(arr, i, arr.length-1);
        }

        return String.valueOf(arr);
    }

    //#region LeetcodeResearch

    // 0 ms runtime
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0 || k < 0) return null;

        char[] chars = s.toCharArray();

        int slow = 0;
        while (slow <= chars.length - k) {
            int fast = slow + k - 1;
            reverse(slow, fast, chars);
            slow = fast + 1 + k;
        }
        if (slow < chars.length) {
            reverse(slow, chars.length - 1, chars);
        }

        return new String(chars);
    }

    private void reverse(int s, int e, char[] chars) {
        while (s < e) {
            char tmp = chars[s];
            chars[s] = chars[e];
            chars[e] = tmp;
            s++;
            e--;
        }
    }

    //#endRegion
}
