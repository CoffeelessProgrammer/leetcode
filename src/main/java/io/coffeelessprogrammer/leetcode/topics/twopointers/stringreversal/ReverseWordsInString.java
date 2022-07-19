package io.coffeelessprogrammer.leetcode.topics.twopointers.stringreversal;

/*
 * 151. Reverse Words in a String
 * Difficulty: Medium
 * Acceptance Rate: 29.0%
 * URL: https://leetcode.com/problems/reverse-words-in-a-string/
 *
 * Runtime: 4 ms, faster than 93.82% of Java online submissions for Reverse Words in a String.
 * Memory Usage: 42.6 MB, less than 83.13% of Java online submissions for Reverse Words in a String.
 */
public class ReverseWordsInString {

    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s.length());

        final int firstSignificantIndex = findNextSignificant(s, s.length()-1);
        if(firstSignificantIndex < 0) return "";

        for(int i=firstSignificantIndex, wordEnd=i; i >= 0; --i) {

            if(i == 0 || s.charAt(i-1)== ' ') {
                for(int j=i; j <= wordEnd; ++j) sb.append(s.charAt(j));

                i = findNextSignificant(s, i-2);

                if(i >= 0) sb.append(' ');

                wordEnd = i++;
            }
        }

        return sb.toString();
    }

    private static int findNextSignificant(String s, int startFrom) {
        for(int i=startFrom; i >=0; --i)
            if(s.charAt(i) != ' ') return i;

        return -1;
    }

    //#region LeetcodeResearch

    // 1 ms runtime
    public String reverseWords(String s) {
        char[] initArr = s.toCharArray();
        int len = initArr.length;
        char[] result = new char[len + 1];

        int newArrPos = 0;
        //i进行整体对原字符数组从后往前遍历
        int i = len - 1;

        while (i >= 0) {
            while (i >= 0 && initArr[i] == ' ') i--;
            int right = i;
            while (i >= 0 && initArr[i] != ' ') i--;

            for (int j = i+1; j <= right; j++) {
                result[newArrPos++] = initArr[j];
                if (j == right)
                    result[newArrPos++] = ' ';
            }
        }

        if (newArrPos == 0)
            return "";
        else
            return new String(result, 0, newArrPos - 1);
    }

    //#endRegion

}
