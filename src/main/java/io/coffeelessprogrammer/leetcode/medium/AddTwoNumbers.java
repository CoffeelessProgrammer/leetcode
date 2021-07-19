package io.coffeelessprogrammer.leetcode.medium;

import io.coffeelessprogrammer.leetcode.ds.ListNode;

/*
 * Problem: 2. Add Two Numbers
 * Acceptance Rate: 36.4%
 * URL: https://leetcode.com/problems/add-two-numbers/
 *
 * Runtime: 2 ms, faster than 67.95% of Java online submissions for Add Two Numbers.
 * Memory Usage: 39.4 MB, less than 38.28% of Java online submissions for Add Two Numbers.
 */

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode firstHead, ListNode secondCurrent) {

        ListNode firstCurrent = firstHead;

        while(secondCurrent != null) {
            firstCurrent.val = firstCurrent.val + secondCurrent.val;

            // Carryover to next digit
            if(firstCurrent.val > 9) {
                firstCurrent.val -= 10;
                carryover(firstCurrent);
            }

            if(secondCurrent.next != null && firstCurrent.next == null) {
                firstCurrent.next = new ListNode(0);
            }

            if(firstCurrent.next == null) break;

            firstCurrent = firstCurrent.next;
            secondCurrent = secondCurrent.next;
        }

        // Complete any remaining carryover
        while(firstCurrent.val > 9 ) {
            firstCurrent.val -= 10;
            carryover(firstCurrent);

            firstCurrent = firstCurrent.next;
        }

        return firstHead;
    }

    // #region Helpers

    private static void carryover(ListNode current) {
        carryover(current, 1);
    }

    private static void carryover(ListNode current, int carryover) {
        if(current.next == null) {
            current.next = new ListNode(carryover);
        } else {
            current.next.val += carryover;
        }
    }

    private static int getNumDigits(ListNode ln) {
        if(ln == null) return 0;

        int digitCount = 1;

        while(ln.next != null) {
            ++digitCount;
            ln = ln.next;
        }

        return digitCount;
    }

    public static long ReverseLinkedListToLong(ListNode ln) {
        long num = 0;

        for(int i=0; ln != null; ++i) {
            num += (Math.pow(10, i) * ln.val);
            ln = ln.next;
        }

        return num;
    }

    public static ListNode LongToReverseLinkedList(long num) {
        ListNode head = new ListNode((int) (num % Math.pow(10,1)));

        final int numDigits = Long.toString(num).length();

        ListNode currentNode = head;

        for(int i=1; i < numDigits; ++i) {
            currentNode.next = new ListNode();
            currentNode = currentNode.next;

            currentNode.val = (int) ((num % Math.pow(10,i+1)) / Math.pow(10,i));   // Extract & store next digit
        }

        return head;
    }

    public static ListNode LongToLinkedList(long num) {
        ListNode head = new ListNode();

        final int numDigits = Long.toString(num).length();

        ListNode currentNode = head;

        for(int i=numDigits; i > 0; --i) {
            currentNode.val = (int) (num / Math.pow(10,i-1));   // Extract & store most significant digit

            num -= (Math.pow(10,i-1) * currentNode.val);        // Remove most significant digit

            if(num > 0) {
                currentNode.next = new ListNode();
                currentNode = currentNode.next;
            }
        }

        return head;
    }

    // #endRegion

    // #region BruteForce

    public static ListNode addTwoNumbersBF(ListNode l1, ListNode l2) {

        final long num1 = ReverseLinkedListToLong(l1);
        final long num2 = ReverseLinkedListToLong(l2);

        final long sum = num1 + num2;

        return LongToReverseLinkedList(sum);
    }

    // #endRegion
}
