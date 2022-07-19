package io.coffeelessprogrammer.leetcode.topics.twopointers.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Problem: 3. Longest Substring Without Repeating Characters
 * Difficulty: Medium
 * Acceptance Rate: 33.4%
 * URL: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Runtime: 7 ms, faster than 81.64% of Java online submissions for Longest Substring Without Repeating Characters.
 * Memory Usage: 43.3 MB, less than 80.86% of Java online submissions for Longest Substring Without Repeating Characters.
 */

public class LongestSubstringNoRepeatingChar {

    public static int getLength(String str) {
        int maxLength = 0;
        Map<Character, Integer> letters = new HashMap<>();

        char currentLetter;
        int previousPosition;

        for(int i=0, j=0; i<str.length(); ++i) {
            currentLetter = str.charAt(i);

            if(letters.containsKey(currentLetter)) {
                previousPosition = letters.get(currentLetter);
                while(j <= previousPosition) {
                    letters.remove(str.charAt(j++));
                }
            }

            letters.put(currentLetter, i);
            maxLength = Math.max(maxLength, i-j+1);
        }

        return maxLength;
    }

    //#region LeetcodeResearch

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

    /** Runtime: 1 ms
     */
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, longest = 0;
        int[] chars = new int[95];
        int offset = 32;

        while (r < s.length()) {
            int c = s.charAt(r);
            l = Math.max(chars[c - offset], l);
            longest = Math.max(longest, r - l + 1);
            chars[c - offset] = r + 1;
            r++;
        }

        return longest;
    }

    //#endRegion

    // #region Year2021

    /*
     * Runtime: 83 ms, faster than 14.91% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 39.6 MB, less than 47.86% of Java online submissions for Longest Substring Without Repeating Characters.
     *
     *   ↓ Post Optimization
     *
     * Runtime: 4 ms, faster than 91.22% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 38.6 MB, less than 98.29% of Java online submissions for Longest Substring Without Repeating Characters.
     */
    public static int getLength2021(String str) {
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

    public static int getLengthBF2021(String str) {
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
}
