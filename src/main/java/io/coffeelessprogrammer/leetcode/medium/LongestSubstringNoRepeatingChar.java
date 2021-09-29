package io.coffeelessprogrammer.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Problem: 3. Longest Substring Without Repeating Characters
 * Acceptance Rate: 32.2%
 * URL: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Runtime: 83 ms, faster than 14.91% of Java online submissions for Longest Substring Without Repeating Characters.
 * Memory Usage: 39.6 MB, less than 47.86% of Java online submissions for Longest Substring Without Repeating Characters.
 *
 *   ↓ Post Optimization
 *
 * 4 ms, faster than 91.22% of Java online submissions for Longest Substring Without Repeating Characters.
 * Memory Usage: 38.6 MB, less than 98.29% of Java online submissions for Longest Substring Without Repeating Characters.
 */

public class LongestSubstringNoRepeatingChar {

    public static int getLength(String str) {
        Map<Character, Integer> found = new HashMap<>();

        int lengthOfLongestSubstring = 0, windowStart=0;

        for(int i=0; i < str.length(); ++i) {
            // System.out.println("substringStart=" + windowStart + ", i=" + i + ", char=" + str.charAt(i));

            if(found.containsKey(str.charAt(i))) {
                int repeatedCharIndex = found.get(str.charAt(i));
                if(repeatedCharIndex >= windowStart) {
                    windowStart = repeatedCharIndex + 1;
                }
            }
            found.put(str.charAt(i), i);
            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, i-windowStart+1);
        }

        // System.out.println("Result for '" + str + "' = " + lengthOfLongestSubstring + "\n\n");

        return lengthOfLongestSubstring;
    }

    // #region BruteForce

    public static int getLengthBF(String str) {
        Map<Character, Integer> found = new HashMap<>();

        int i=0, j=0;

        int lengthOfLongestSubstring = 0;

        while(i < str.length()) {
            System.out.println("substringStart=" + j + ", i=" + i + ", char=" + str.charAt(i));

            if(found.containsKey(str.charAt(i))) {
                System.out.println("  Repeat found X_X");
                if(i-j > lengthOfLongestSubstring) lengthOfLongestSubstring = i-j;

                j = found.get(str.charAt(i)) + 1;
                i = j-1;

                found.clear();
            } else {
                System.out.println("  Adding :)");
                found.put(str.charAt(i), i);
            }

            ++i;

            if(i == str.length()) {
                if(i-j > lengthOfLongestSubstring) lengthOfLongestSubstring = i-j;
            }
        }

        System.out.println("Result for '" + str + "' = " + lengthOfLongestSubstring + "\n\n");

        return lengthOfLongestSubstring;
    }

    // #endRegion

    public static int jeantimax(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
}
