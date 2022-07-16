package io.coffeelessprogrammer.leetcode.twopointers.linkedlists;

import io.coffeelessprogrammer.leetcode.ds.ListNode;

import java.util.Stack;

/*
 * Problem: 19. Remove Nth Node From End of List
 * Difficulty: Medium
 * Acceptance Rate: 38.6%
 * URL: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
 * Memory Usage: 42.4 MB, less than 43.23% of Java online submissions for Remove Nth Node From End of List.
 *
 * Visual Explanation: https://www.instagram.com/p/CgCIVxguWxm/?igshid=YmMyMTA2M2Y=
 */
public class RemoveNthNodeFromEndOfLL {
    public ListNode remove(ListNode head, int n) {
        if(n < 1) return head;
        if(head==null) return null;

        ListNode penguin=head, fish=head;

        int size = 1;

        while(fish.next != null) {
            fish = fish.next;
            if(++size > n+1) penguin = penguin.next;
        }

        if(size==1) return null;
        else if(n==size) return head.next;

        penguin.next = penguin.next.next;   // Delete Nth node

        return head;
    }

    public ListNode removeOptimized(ListNode head, int n) {
        if(head==null || head.next==null) return null;

        ListNode penguin=head, fish=head;

        for(int size = 1; size < n+1 ; ++size)
            fish = fish.next;

        if(fish==null) return head.next;    // i.e. n == listSize

        while(fish.next != null) {
            fish = fish.next;
            penguin = penguin.next;
        }

        penguin.next = penguin.next.next;   // Delete Nth node

        return head;
    }

    //#region LeetcodeResearch

    /** Memory Usage: 40.0 MB
     */
    public ListNode removeNthFromEndL1(ListNode head, int n) {
        Stack<ListNode> node = new Stack<>();

        ListNode head1 = new ListNode(-1);
        head1.next=head;
        ListNode head2=head1;

        while (head1 != null) {
            node.add(head1);
            head1 = head1.next;
        }

        while(node.size()>0 && n>=0) {
            ListNode tmp = node.pop();

            if(n==0) {
                tmp.next = tmp.next.next;
                break;
            }

            n--;
        }

        return head2.next;
    }

    //#endregion
}
