package io.coffeelessprogrammer.leetcode.graphsearch;

import io.coffeelessprogrammer.leetcode.ds.Coordinate;

import java.util.Stack;

/*
 * Problem: 733. Flood Fill
 * Difficulty: Easy
 * Acceptance Rate: 58.7%
 * URL: https://leetcode.com/problems/flood-fill/
 *
 * Runtime: 1 ms, faster than 90.52% of Java online submissions for Flood Fill.
 * Memory Usage: 47.7 MB, less than 70.63% of Java online submissions for Flood Fill.
 *
 * Visual Explanation: https://www.instagram.com/p/Cf_lY-ZrLv2/?igshid=YmMyMTA2M2Y=
 */
public class FloodFill {

    //#region Recursion Impl

    private int[][] image;
    private int ROWS, COLS;
    private int originColor, newColor;

    /* Runtime: 1 ms, faster than 90.52% of Java online submissions for Flood Fill.
     * Memory Usage: 47.7 MB, less than 70.63% of Java online submissions for Flood Fill.
     */
    public int[][] floodFillRecursive(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;

        this.image = image;
        this.ROWS = image.length;
        this.COLS = image[0].length;
        this.originColor = image[sr][sc];
        this.newColor = color;

        DFS(sr, sc);

        return this.image;
    }

    private void DFS(int r, int c){
        if( r < 0 || r >= this.ROWS || c < 0 || c >= COLS ||
                this.image[r][c] != this.originColor ) return;

        this.image[r][c] = this.newColor;

        DFS(r+1, c);
        DFS(r-1, c);
        DFS(r, c+1);
        DFS(r, c-1);
    }

    //#endregion

    //#region Stack/Queue Impl

    private static final Stack<Coordinate> coordinates = new Stack<>();
    // private static boolean[][] visited;

    /* Runtime: 2 ms, faster than 34.32% of Java online submissions for Flood Fill.
     * Memory Usage: 47.9 MB, less than 56.58% of Java online submissions for Flood Fill.
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;

        final int maxRows = image.length;
        final int maxColumns = image[0].length;
        final int startingColor = image[sr][sc];

        // Push & mark
        coordinates.add(new Coordinate(sr, sc));
        image[sr][sc] = color;

        int rowAbove, columnToRight, rowBelow, columnToLeft;

        Coordinate current;

        while(!coordinates.isEmpty()) {
            current = coordinates.pop();

            rowAbove = current.row()-1;
            columnToRight = current.col()+1;
            rowBelow = current.row()+1;
            columnToLeft = current.col()-1;

            if(rowAbove >= 0) {
                if(image[rowAbove][current.col()] == startingColor)
                    pushAndMark(rowAbove, current.col(), image, color);
            }

            if(columnToRight < maxColumns) {
                if(image[current.row()][columnToRight] == startingColor)
                    pushAndMark(current.row(), columnToRight, image, color);
            }

            if(rowBelow < maxRows) {
                if(image[rowBelow][current.col()] == startingColor)
                    pushAndMark(rowBelow, current.col(), image, color);
            }

            if(columnToLeft >= 0) {
                if(image[current.row()][columnToLeft] == startingColor)
                    pushAndMark(current.row(), columnToLeft, image, color);
            }
        }

        return image;
    }

    /** Push coordinate to stack and mark with new color */
    private static void pushAndMark(int row, int column, int[][] image, int newColor) {
        image[row][column] = newColor;
        coordinates.add(new Coordinate(row, column));
    }

    //#endregion

    //#region LeetcodeResearch


    public int[][] floodFillLowMemory(int[][] image, int sr, int sc, int color) {
        int targetColor = image[sr][sc];
        // edge case
        if (targetColor == color) return image;

        dfs(sr, sc, image, color, targetColor);

        return image;
    }

    private final static int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    private void dfs(int x, int y, int[][] image, int color, int targetColor) {
        image[x][y] = color;

        for (var direction : directions) {
            int X = x + direction[0];
            int Y = y + direction[1];

            if (X < 0 || Y < 0 || X >= image.length || Y >= image[0].length)
                continue;

            if (image[X][Y] != targetColor) continue;

            dfs(X, Y, image, color, targetColor);
        }
    }

    //#endregion
}
