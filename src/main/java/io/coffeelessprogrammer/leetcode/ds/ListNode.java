package io.coffeelessprogrammer.leetcode.ds;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void display(String listName) {
        System.out.print(listName + ": " + val);

        ListNode currentNode = this.next;

        while(currentNode  != null) {
            System.out.print(" -> " + currentNode.val);
            currentNode = currentNode.next;
        }

        System.out.println();
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
