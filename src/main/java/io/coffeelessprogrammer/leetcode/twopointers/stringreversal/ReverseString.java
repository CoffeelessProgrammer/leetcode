package io.coffeelessprogrammer.leetcode.twopointers.stringreversal;

/*
 * Problem: 344. Reverse String
 * Difficulty: Easy
 * Acceptance Rate: 75.2%
 * URL: https://leetcode.com/problems/reverse-string/
 *
 * Runtime: 1 ms, faster than 99.78% of Java online submissions for Reverse String.
 * Memory Usage: 53.9 MB, less than 77.74% of Java online submissions for Reverse String.
 */
public class ReverseString {

    public void reverse(char[] s) {
        for(int i=0; i < s.length/2; ++i) {
            swap(s, i, s.length-1-i);
        }
    }

    private static void swap(char[] arr, int m, int n) {
        arr[n] -= arr[m];
        arr[m] += arr[n];
        arr[n] = (char) (arr[m] - arr[n]);
    }

    public void reverseTwoPointer(char[] s) {
        final int midpoint = s.length/2;

        char temp;

        for(int i=0, j=s.length-1; i < midpoint; ++i, --j) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

    //#region LeetcodeResearch

    // 1 ms runtime
    public void reverseString1ms(char[] s) {
        int i=0, j=s.length-1;

        while(i<j){
            char temp = s[i];
            s[i++] = s[j];
            s[j--]=temp;
        }
    }

    // 0 ms runtime?
    public void reverseString0ms(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    //#endRegion
}
