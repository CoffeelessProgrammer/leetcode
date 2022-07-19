package io.coffeelessprogrammer.leetcode.topics.twopointers.linkedlists;

import io.coffeelessprogrammer.leetcode.datastructures.ListNode;

/*
 * Problem: 2095. Delete the Middle Node of a Linked List
 * Difficulty: Medium
 * Acceptance Rate: 56.3%
 * URL: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 *
 * Runtime: 5 ms, faster than 74.64% of Java online submissions for Delete the Middle Node of a Linked List.
 * Memory Usage: 206.8 MB, less than 70.22% of Java online submissions for Delete the Middle Node of a Linked List.
 *
 * Visual Explanation: https://www.instagram.com/p/Cf13pvEvInj/?igshid=YmMyMTA2M2Y=
 */
public class DeleteMiddleNodeOfLL {

    public ListNode remove(ListNode head) {
        if(head.next == null) return null;  // i.e. listSize = 1

        ListNode duck = head;
        ListNode frog = new ListNode(-1, head);

        while(duck.next != null) {
            duck = duck.next.next;
            frog = frog.next;
            if(duck==null) break;
        }

        frog.next = frog.next.next;

        return head;
    }

    public ListNode removeStepByStepTraversal(ListNode head) {
        if(head.next == null) return null;  // i.e. listSize = 1

        ListNode duck = head;
        ListNode frog = new ListNode(-1, head);

        for(int i=0; duck.next != null; ++i) {
            duck = duck.next;
            if(i%2==0) frog = frog.next;
        }

        frog.next = frog.next.next;

        return head;
    }

    //#region LeetcodeResearch

    /* Why is this faster?
     * Probably because rabbit moves two spots ahead every iteration
     */

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
