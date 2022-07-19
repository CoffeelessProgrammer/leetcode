package io.coffeelessprogrammer.leetcode.difficulty.easy;

/*
 * Problem: 58. Length of Last Word
 * Acceptance Rate: 34.4%
 * URL: https://leetcode.com/problems/length-of-last-word/
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Length of Last Word.
 * Memory Usage: 37.3 MB, less than 66.93% of Java online submissions for Length of Last Word.
 */

public class LengthOfLastWord {

    public static int find(String s) {
        int lengthOfLastWord = 0;

        boolean firstLetterFound = false;

        for(int i=s.length()-1; i > -1; --i) {
            if(firstLetterFound) {
                if(s.charAt(i) != ' ')
                    ++lengthOfLastWord;
                else
                    break;
            } else if(s.charAt(i) != ' ') {
                ++lengthOfLastWord;
                firstLetterFound = true;
            }
        }

        return lengthOfLastWord;
    }
}
