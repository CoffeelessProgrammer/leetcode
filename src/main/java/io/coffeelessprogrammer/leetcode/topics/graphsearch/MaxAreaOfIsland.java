package io.coffeelessprogrammer.leetcode.topics.graphsearch;

/*
 * Problem: 695. Max Area of Island
 * Difficulty: Medium
 * Acceptance Rate: 70.2%
 * URL: https://leetcode.com/problems/max-area-of-island/
 *
 * Runtime: 2 ms, faster than 100.00% of Java online submissions for Max Area of Island.
 * Memory Usage: 42.4 MB, less than 90.38% of Java online submissions for Max Area of Island.
 */
public class MaxAreaOfIsland {

    private int[][] seachart;
    private int ROWS, COLS;

    public int areaOfLargestIsland(int[][] grid) {
        // List<Integer> islandAreas = new ArrayList<>();
        int areaOfLargestIsland = 0, islandArea;

        this.seachart = grid;
        this.ROWS = grid.length;
        this.COLS = grid[0].length;

        for(int r=0; r < grid.length; ++r) {
            for(int c=0; c < grid[0].length; ++c) {

                if(grid[r][c] == 1) {
                    islandArea = getIslandArea(r, c);
                    if(islandArea > areaOfLargestIsland) areaOfLargestIsland = islandArea;
                }
            }
        }

        return areaOfLargestIsland;
    }

    private int getIslandArea(int row, int col) {
        return DFS(row, col);
    }

    private int DFS(int r, int c) {
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS
                || seachart[r][c] != 1) return 0;

        seachart[r][c] = 2; // Mark tile seen

        int area = 1;

        area += DFS(r-1, c);    // Top
        area += DFS(r, c+1);    // Right
        area += DFS(r+1, c);    // Bottom
        area += DFS(r, c-1);    // Left

        return area;
    }
}
