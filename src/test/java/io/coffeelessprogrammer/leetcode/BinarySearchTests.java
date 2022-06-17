package io.coffeelessprogrammer.leetcode;

import io.coffeelessprogrammer.leetcode.binarysearch.SearchInsertPosition;
import org.junit.jupiter.api.Test;

import io.coffeelessprogrammer.leetcode.binarysearch.BinarySearch;
import io.coffeelessprogrammer.leetcode.binarysearch.FirstBadVersion;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTests {

    //#region BinarySearch

    @Test
    final void BinarySearch_ArraySize6() {
        assertEquals(4,
                BinarySearch.search(new int[]{-1,0,3,5,9,12}, 9));
    }

    //#endRegion

    //#region FirstBadVersion

    @Test
    final void FirstBadVersion_5() {
        assertEquals(4,
                FirstBadVersion.search(5,4));
    }

    @Test
    final void FirstBadVersion_2() {
        assertEquals(1,
                FirstBadVersion.search(2,1));
    }

    @Test
    final void FirstBadVersion_3() {
        assertEquals(2,
                FirstBadVersion.search(3,2));
    }

    @Test
    final void FirstBadVersion_2126753390() {
        assertEquals(1702766719,
                FirstBadVersion.search(2126753390,1702766719));
    }

    @Test
    final void FirstBadVersion_MinimalApiCalls_3() {
        assertEquals(2,
                FirstBadVersion.searchMinimalApiCalls(3,2));
    }

    @Test
    final void FirstBadVersion_MinimalApiCalls_3Versions_LastIndexBad() {
        assertEquals(3,
                FirstBadVersion.searchMinimalApiCalls(3,3));
    }

    @Test
    final void FirstBadVersion_MinimalApiCalls_2126753390() {
        assertEquals(1702766719,
                FirstBadVersion.searchMinimalApiCalls(2126753390,1702766719));
    }

    //#endRegion

    //#region SearchInsertPosition

    private final SearchInsertPosition searchInsertPosition = new SearchInsertPosition();

    @Test
    final void SearchInsertPosition_Found() {
        assertEquals(2,
                searchInsertPosition.find(new int[]{1,3,5,6}, 5));
    }

    @Test
    final void SearchInsertPosition_Found2() {
        assertEquals(1,
                searchInsertPosition.find(new int[]{1,3}, 3));
    }

    @Test
    final void SearchInsertPosition_InsertFirst() {
        assertEquals(0,
                searchInsertPosition.find(new int[]{4,8,16,32,54}, 2));
    }

    @Test
    final void SearchInsertPosition_InsertLast() {
        assertEquals(4,
                searchInsertPosition.find(new int[]{1,3,5,6}, 7));
    }

    @Test
    final void SearchInsertPosition_InsertBetween() {
        assertEquals(1,
                searchInsertPosition.find(new int[]{1,3}, 2));
    }

    @Test
    final void SearchInsertPosition_InsertBetween2() {
        assertEquals(1,
                searchInsertPosition.find(new int[]{1,3,5,6}, 2));
    }

    @Test
    final void SearchInsertPosition_InsertBetween3() {
        assertEquals(2,
                searchInsertPosition.find(new int[]{1,3,5}, 4));
    }

    //#endRegion
}
