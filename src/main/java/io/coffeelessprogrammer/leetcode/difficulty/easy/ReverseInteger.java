package io.coffeelessprogrammer.leetcode.difficulty.easy;

/*
 * Problem: 7. Reverse Integer
 * Acceptance Rate: 26.1%
 * URL: https://leetcode.com/problems/reverse-integer/
 *
 * Runtime: 2 ms, faster than 41.02% of Java online submissions for Reverse Integer.
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Integer.
 * Memory Usage: 36.3 MB, less than 44.83% of Java online submissions for Reverse Integer.
 */

public class ReverseInteger {

    public static int reverse(int x) {
        if(isOverflowDetected(x)) return 0;

        int reversed = 0;

        while(x != 0) {
             reversed *= 10;
             reversed += x%10;  // Append extracted digit
            // reversed = reversed * 10 + x % 10;

             x /= 10;
        }

        return reversed;
    }

    // Max int: 2,147,483,647
    // Min int: -2,147,483,648
    public static boolean isOverflowDetected(int x) {
        int digitCount = countDigits(x);

        if(digitCount > 9) {

            final int[] intMax = new int[]{2,1,4,7,4,8,3,6,4,7};
            final int[] intMin = new int[]{-2,-1,-4,-7,-4,-8,-3,-6,-4,-8};

            if(x > 0) {
                for(int i=0; i < digitCount; ++i) {
                    if(x%10 > intMax[i])
                        return true;
                    else if(x%10 == intMax[i])
                        x /= 10;
                    else
                        return false;
                }
            } else {
                for(int i=0; i < digitCount; ++i) {
                    if(x%10 < intMin[i])
                        return true;
                    else if(x%10 == intMin[i])
                        x /= 10;
                    else
                        return false;
                }
            }

            return false;
        }

        return false;
    }

    public static int countDigits(int x) {
        int digitCount = 0;

        while(x != 0) {
            ++digitCount;
            x /= 10;
        }

        return digitCount;
    }

    //#region LeetcodeResearch

    public static int reverseAlt(int x) {
        int reversed = 0;

        while (x != 0) {
            int lastDigit = x % 10;
            int temp = reversed * 10 + lastDigit;   /* Temporarily store the extracted digit appended to the reversed number */

            /*    Overflow Check
             * If undoing the digit append doesn't result
             * in the most recent reversed state, then
             * overflow has occurred.
             */
            if ((temp - lastDigit) / 10 != reversed)
                return 0;
            else
                reversed = temp;

            x /= 10;
        }

        return reversed;
    }

    //#endRegion
}
