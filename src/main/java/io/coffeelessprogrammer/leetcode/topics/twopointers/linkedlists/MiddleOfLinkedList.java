package io.coffeelessprogrammer.leetcode.topics.twopointers.linkedlists;

import io.coffeelessprogrammer.leetcode.datastructures.ListNode;

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
 * Problem: 876. Middle of the Linked List
 * Difficulty: Easy
 * Acceptance Rate: 73.0%
 * URL: https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
 * Memory Usage: 41.6 MB, less than 46.12% of Java online submissions for Middle of the Linked List.
 */
public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode turtle = head, rabbit = head;

        for(int i=0; rabbit.next != null; ++i) {
            rabbit = rabbit.next;
            if(i%2==0) turtle = turtle.next;
        }

        return turtle;
    }

    //#region LeetcodeResearch

    /** Memory Usage: 39.4 MB
     */
    public ListNode middleNodeLowSpace(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    //#endregion
}
