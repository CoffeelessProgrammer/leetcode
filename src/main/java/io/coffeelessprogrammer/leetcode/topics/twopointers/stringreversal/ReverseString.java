package io.coffeelessprogrammer.leetcode.topics.twopointers.stringreversal;

/*
 * Problem: 344. Reverse String
 * Difficulty: Easy
 * Acceptance Rate: 75.2%
 * URL: https://leetcode.com/problems/reverse-string/
 *
 * Runtime: 1 ms, faster than 99.91% of Java online submissions for Reverse String.
 * Memory Usage: 53.9 MB, less than 77.74% of Java online submissions for Reverse String.
 */
public class ReverseString {

    public void reverse(char[] s) {
        int left=0, right=s.length-1;

        while(left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    public void reverseForLoop(char[] s) {
        for(int left=0, right=s.length-1; left < right; ++left, --right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

    public void reverseInplace(char[] s) {
        for(int i=0; i < s.length/2; ++i) {
            inplaceSwap(s, i, s.length-1-i);
        }
    }

    private static void inplaceSwap(char[] arr, int m, int n) {
        arr[n] -= arr[m];
        arr[m] += arr[n];
        arr[n] = (char) (arr[m] - arr[n]);
    }

}
