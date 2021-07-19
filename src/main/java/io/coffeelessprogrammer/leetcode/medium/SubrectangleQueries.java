package io.coffeelessprogrammer.leetcode.medium;

/*
 * Problem: 1476. Subrectangle Queries
 * Acceptance Rate: 87.9%
 * URL: https://leetcode.com/problems/subrectangle-queries/
 *
 * Runtime: 23 ms, faster than 93.52% of Java online submissions for Subrectangle Queries.
 * Memory Usage: 42.9 MB, less than 41.95% of Java online submissions for Subrectangle Queries.
 */

import java.util.Arrays;

public class SubrectangleQueries {

    private int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i=row1; i < row2+1; ++i) {
            for (int j=col1; j < col2+1; ++j) {
                this.rectangle[i][j] = newValue;
            }
        }
    }

    /** Uses a bit more memory, but should be faster?
     */
    public void updateSubrectangleMemory(int row1, int col1, int row2, int col2, int newValue) {
        final int subrectangleWidth = col2-col1+1;

        // Populate an array of the new value
        int[] section = new int[subrectangleWidth];
        Arrays.fill(section, newValue);

        // Replace the section in each row via arraycopy
        for (int i=row1; i < row2+1; ++i) {
            System.arraycopy(section, 0, this.rectangle[i], col1, subrectangleWidth);
        }
    }
}
