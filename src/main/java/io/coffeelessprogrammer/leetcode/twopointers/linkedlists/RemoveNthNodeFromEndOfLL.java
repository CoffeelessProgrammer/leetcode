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
 */
public class RemoveNthNodeFromEndOfLL {

    public ListNode removeNode(ListNode head, int n) {
        if(head==null) return null;

        ListNode dora=head, swiper=head;

        int size = 1;

        for(int i=0; dora.next != null; ++i) {
            dora = dora.next;
            ++size;
            if(i >= n) swiper = swiper.next;
        }

        if(size==1) return null;

        if(n != size) {
            if(swiper.next != null)
                swiper.next = swiper.next.next;
        }

        return n==size ? head.next : head;
    }

    //#region LeetcodeResearch

    /** Memory Usage: 40.0 MB
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> node = new Stack<ListNode>();

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

    //#endRegion
}
