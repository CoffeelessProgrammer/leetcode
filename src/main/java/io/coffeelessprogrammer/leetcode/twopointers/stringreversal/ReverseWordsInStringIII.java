package io.coffeelessprogrammer.leetcode.twopointers.stringreversal;

import io.coffeelessprogrammer.leetcode.utility.Array;

/*
 * Problem: 557. Reverse Words in a String III
 * Difficulty: Easy
 * Acceptance Rate: 79.3%
 * URL: https://leetcode.com/problems/reverse-words-in-a-string-iii/
 *
 * Runtime: 7 ms, faster than 74.71% of Java online submissions for Reverse Words in a String III.
 * Memory Usage: 48.9 MB, less than 76.09% of Java online submissions for Reverse Words in a String III.
 */
public class ReverseWordsInStringIII {

    public String reverseWordsStringBuilder(String s) {
        final char SPACE = ' ';

        StringBuilder sb = new StringBuilder(s.length()*2);

        for(int i=0, wordStart=0; i < s.length(); ++i) {

            if(i+1 == s.length() || s.charAt(i+1) == ' ') {
                for(int j=i; j >= wordStart; --j) sb.append(s.charAt(j));

                wordStart = ++i + 1;
                if(wordStart < s.length()) sb.append(SPACE);
            }
        }

        return sb.toString();
    }

    public String reverseWordsCharArray(String s) {
        final char[] arr = s.toCharArray();

        for(int i=0, wordStart=0; i < arr.length; ++i) {

            if(i+1 == s.length() || s.charAt(i+1) == ' ') {
                Array.reverseSegment(arr, wordStart, i);

                wordStart = ++i + 1;
            }
        }

        return String.valueOf(arr);
    }
}
