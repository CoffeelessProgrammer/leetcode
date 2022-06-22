package io.coffeelessprogrammer.leetcode;

import io.coffeelessprogrammer.leetcode.twopointers.MoveZeroes;
import io.coffeelessprogrammer.leetcode.twopointers.RotateArray1d;
import io.coffeelessprogrammer.leetcode.twopointers.SquaresOfSortedArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoPointersTests {

    //#region SquaresOfSortedArray

    private SquaresOfSortedArray squaresOfSortedArray = new SquaresOfSortedArray();

    @Test
    final void SortedSquares_Basic() {
        assertArrayEquals(new int[]{0,1,9,16,100},
                squaresOfSortedArray.sortedSquares(new int[]{-4,-1,0,3,10}));
    }

    @Test
    final void SortedSquares_Basic2() {
        assertArrayEquals(new int[]{4,9,9,49,121},
                squaresOfSortedArray.sortedSquares(new int[]{-7,-3,2,3,11}));
    }

    //#endRegion

    //#region RotateArray1d

    private RotateArray1d rotateArray1d = new RotateArray1d();

    @Test
    final void RotateArray1d_LinearSpace() {
        final int[] arr = {1,2,3,4,5,6,7};

        rotateArray1d.rotate(arr, 3);

        assertArrayEquals(new int[]{5,6,7,1,2,3,4}, arr);
    }

    @Test
    final void RotateArray1d_Inplace() {
        final int[] arr = {1,2,3,4,5,6,7};

        rotateArray1d.rotateInplace(arr, 3);

        assertArrayEquals(new int[]{5,6,7,1,2,3,4}, arr);
    }

    @Test
    final void RotateArray1d_Inplace_1CycleOscillation() {
        final int[] arr = {-1,-100,3,99};

        rotateArray1d.rotateInplace(arr, 2);

        assertArrayEquals(new int[]{3,99,-1,-100}, arr);
    }

    @Test
    final void RotateArray1d_Inplace_2CycleOscillation() {
        final int[] arr = {2,4,8,16,32,64};

        rotateArray1d.rotateInplace(arr, 4);

        assertArrayEquals(new int[]{8,16,32,64,2,4}, arr);
    }

    @Test
    final void RotateArray1d_Inplace_2CycleOscillation_Verbose() {
        final int[] arr = {2,4,8,16,32,64};

        rotateArray1d.rotateInplaceVerbose(arr, 4);

        assertArrayEquals(new int[]{8,16,32,64,2,4}, arr);
    }

    //#endRegion

    //#region MoveZeroes

    private MoveZeroes moveZeroes = new MoveZeroes();

    @Test
    final void MoveZeroes_Inplace() {
        final int[] arr = {0,1,0,3,12};

        moveZeroes.bubble(arr);

        assertArrayEquals(new int[]{1,3,12,0,0}, arr);
    }

    //#endRegion
}
