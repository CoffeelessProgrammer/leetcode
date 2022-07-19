package io.coffeelessprogrammer.leetcode.medium;

import io.coffeelessprogrammer.leetcode.datastructures.ListNode;

import io.coffeelessprogrammer.leetcode.difficulty.medium.AddTwoNumbers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTwoNumbersTests {

    private final ListNode h342 = AddTwoNumbers.LongToLinkedList(243);
    private final ListNode h465 = AddTwoNumbers.LongToLinkedList(564);
    private final ListNode h9 = AddTwoNumbers.LongToLinkedList(9);
    private final ListNode h9_999_999_991 = AddTwoNumbers.LongToLinkedList(199_999_999_9L);
    private final ListNode h9_999_999 = AddTwoNumbers.LongToLinkedList(9_999_999);
    private final ListNode h9_999 = AddTwoNumbers.LongToLinkedList(9_999);
    private final ListNode h0 = AddTwoNumbers.LongToLinkedList(0);
    private final ListNode h81 = AddTwoNumbers.LongToLinkedList(18);

    @Test
    final void Case_1() {
        ListNode result = AddTwoNumbers.addTwoNumbers(h342, h465);
        result.display("Case 1 Result");
        assertEquals(807, AddTwoNumbers.ReverseLinkedListToLong(result));
    }

    @Test
    final void Case_2() {
        ListNode result = AddTwoNumbers.addTwoNumbers(h9, h9_999_999_991);
        result.display("Case 2 Result");
        assertEquals(10_000_000_000L, AddTwoNumbers.ReverseLinkedListToLong(result));
    }

    @Test
    final void Case_3() {
        ListNode result = AddTwoNumbers.addTwoNumbers(h9_999, h9_999_999);
        result.display("Case 3 Result");
        assertEquals(10_009_998L, AddTwoNumbers.ReverseLinkedListToLong(result));
    }

    @Test
    final void Case_4() {
        ListNode result = AddTwoNumbers.addTwoNumbers(h0, h81);
        result.display("Case 4 Result");
        assertEquals(81, AddTwoNumbers.ReverseLinkedListToLong(result));
    }

    @Test
    final void Case_5() {
        ListNode result = AddTwoNumbers.addTwoNumbers(h81, h0);
        result.display("Case 5 Result");
        assertEquals(81, AddTwoNumbers.ReverseLinkedListToLong(result));
    }

    @Test
    final void Case_6() {
        ListNode result = AddTwoNumbers.addTwoNumbers(h9_999_999, h9_999);
        result.display("Case 6 Result");
        assertEquals(10_009_998L, AddTwoNumbers.ReverseLinkedListToLong(result));
    }
}
