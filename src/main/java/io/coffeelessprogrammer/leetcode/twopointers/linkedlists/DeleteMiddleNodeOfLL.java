package io.coffeelessprogrammer.leetcode.twopointers.linkedlists;

import io.coffeelessprogrammer.leetcode.ds.ListNode;

/*
 * Problem: 2095. Delete the Middle Node of a Linked List
 * Difficulty: Medium
 * Acceptance Rate: 56.3%
 * URL: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 *
 * Runtime: 6 ms, faster than 41.58% of Java online submissions for Delete the Middle Node of a Linked List.
 * Memory Usage: 206.8 MB, less than 70.22% of Java online submissions for Delete the Middle Node of a Linked List.
 */
public class DeleteMiddleNodeOfLL {

    public ListNode remove(ListNode head) {
        if(head.next == null) return null;  // i.e. listSize = 1

        ListNode rabbit = head;
        ListNode frog = new ListNode(-1, head);

        for(int i=0; rabbit.next != null; ++i) {
            rabbit = rabbit.next;
            if(i%2==0) frog = frog.next;
        }

        frog.next = frog.next.next;

        return head;
    }

    //#region LeetcodeResearch

    /* Why are these faster?
     * Probably because they move rabbit two spots ahead every iteration
     */

    /** Runtime: 4 ms
     */
    public ListNode deleteMiddle1(ListNode head) {
        if(head.next == null) return null;
        if(head.next.next == null) {head.next = null; return head;}

        ListNode slow = head, fast = head;
        ListNode prev = new ListNode(0);
        prev.next = head;

        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            prev = prev.next;
        }
        prev.next = slow.next;
        return head;
    }

    /** Runtime: 3 ms
     */
    public ListNode deleteMiddle2(ListNode head) {
        ListNode sp=head;
        ListNode fp=head;
        if(sp.next==null) return null;
        while(fp.next!=null && fp.next.next!=null){
            fp=fp.next.next;
            if(fp.next==null) break;
            sp=sp.next;
        }
        if(sp.next!=null)
            sp.next = sp.next.next;

        return head;
    }

    //#endRegion
}
