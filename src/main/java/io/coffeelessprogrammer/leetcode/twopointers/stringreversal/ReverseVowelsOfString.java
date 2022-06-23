package io.coffeelessprogrammer.leetcode.twopointers.stringreversal;

import io.coffeelessprogrammer.leetcode.utility.Array;

import java.util.HashSet;
import java.util.Set;

/*
 * 345. Reverse Vowels of a String
 * Difficulty: Easy
 * Acceptance Rate: 47.1%
 * URL: https://leetcode.com/problems/reverse-vowels-of-a-string/
 *
 * Runtime: 3 ms, faster than 97.62% of Java online submissions for Reverse Vowels of a String.
 * Memory Usage: 44.1 MB, less than 82.12% of Java online submissions for Reverse Vowels of a String.
 */
public class ReverseVowelsOfString {

    private static final Set<Character> vowels = new HashSet(10);

    static {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }

    // Runtime: 6 ms (69.91%)
    public static String reverseViaVowelDictionary(String s) {
        char[] arr = s.toCharArray();

        int leftmostVowel = findNextVowel(arr, 0, Direction.RIGHT);
        int rightmostVowel = findNextVowel(arr, s.length()-1, Direction.LEFT);

        while(leftmostVowel < rightmostVowel) {
            System.out.printf("%s   %s\n", leftmostVowel, rightmostVowel);
            Array.swapIndices(arr, leftmostVowel, rightmostVowel);

            leftmostVowel = findNextVowel(arr, leftmostVowel+1, Direction.RIGHT);
            rightmostVowel = findNextVowel(arr, rightmostVowel-1, Direction.LEFT);
        }

        return String.valueOf(arr);
    }

    enum Direction {
        RIGHT, LEFT;
    }

    private static int findNextVowel(char[] arr, final int start, Direction traveling) {
        if(traveling == Direction.RIGHT) {
            for(int i=start; i < arr.length; ++i)
                if(vowels.contains(Character.toLowerCase(arr[i]))) return i;
        }
        else {
            for(int i=start; i >= 0; --i)
                if(vowels.contains(Character.toLowerCase(arr[i]))) return i;
        }

        return -1;
    }

    // Runtime: 3 ms (97.62%)
    public static String reverse(String s) {
        char[] arr = s.toCharArray();

        for(int i=0, j=arr.length-1; i < j; ) {
            if(!isVowel(arr[i])) ++i;
            else if(!isVowel(arr[j])) --j;
            else Array.swapIndices(arr, i++, j--);
        }

        return String.valueOf(arr);
    }

    private static boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u'
                || c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
    }
}
