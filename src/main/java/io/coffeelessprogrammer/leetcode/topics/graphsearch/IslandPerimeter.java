package io.coffeelessprogrammer.leetcode.topics.graphsearch;

import io.coffeelessprogrammer.leetcode.datastructures.Coordinate;

import java.util.Stack;

/*
 * Problem: 463. Island Perimeter
 * Difficulty: Easy
 * Acceptance Rate: 69.1%
 * URL: https://leetcode.com/problems/island-perimeter/
 *
 * Runtime: 9 ms, faster than 81.62% of Java online submissions for Island Perimeter.
 * Memory Usage: 42.8 MB, less than 98.51% of Java online submissions for Island Perimeter.
 *
 * Visual Explanation: https://www.instagram.com/p/Cf9K_fnrcj-/?igshid=YmMyMTA2M2Y=
 */
public class IslandPerimeter {

    public static int calculate(int[][] grid) {
        int islandPerimeter = 0;

        for(int r=0; r < grid.length; ++r){
            for(int c=0; c < grid[0].length; ++c){

                if(grid[r][c] == 1){
                    islandPerimeter += 4;
                    if(r>0 && grid[r-1][c]==1) islandPerimeter-=2;
                    if(c>0 && grid[r][c-1]==1) islandPerimeter-=2;
                }
            }
        }

        return islandPerimeter;
    }

    //#region Stack Impl

    /** Find the coordinate of any land tile.
     */
    private int[] landHo() {
        for(int row=0; row < seaChart.length; ++row) {
            for(int col=0; col < seaChart[0].length; ++col)
                if(seaChart[row][col] == 1) return new int[]{ row, col };
        }
        return null;
    }

    private Stack<Coordinate> coordinates = new Stack<>();

    private int[][] seaChart;

    /* Runtime: 25 ms, faster than 8.08% of Java online submissions for Island Perimeter.
     * Memory Usage: 42.8 MB, less than 98.51% of Java online submissions for Island Perimeter.
     */
    public int getPerimeter(int[][] grid) {
        seaChart = grid;
        int[] firstLandSighting = landHo();

        if(firstLandSighting == null) return 0;
        markSeenAndPush(firstLandSighting);

        int islandPerimeter = 0;

        Coordinate X;
        int tilePerimeter;
        int[] topTile = new int[2], rightTile  = new int[2], bottomTile = new int[2], leftTile = new int[2];

        while(!coordinates.isEmpty()) {
            X = coordinates.pop();

            topTile[0] = X.row()-1;
            topTile[1] = X.col();

            rightTile[0] = X.row();
            rightTile[1] = X.col()+1;

            bottomTile[0] = X.row()+1;
            bottomTile[1] = X.col();

            leftTile[0] = X.row();
            leftTile[1] = X.col()-1;

            tilePerimeter = 4;

            if(topTile[0] >= 0 && isLandTile(topTile)) {
                markSeenAndPush(topTile);
                if(topTile[0] > 0) tilePerimeter -= 2;
            }
            if(leftTile[1] >= 0 && isLandTile(leftTile)) {
                markSeenAndPush(leftTile);
                if(leftTile[1] > 0) tilePerimeter -= 2;
            }
            if(bottomTile[0] < grid.length && isLandTile(bottomTile)) {
                markSeenAndPush(bottomTile);
            }
            if(rightTile[1] < grid[0].length && isLandTile(rightTile)) {
                markSeenAndPush(rightTile);
            }

            islandPerimeter += tilePerimeter;

            System.out.printf("Tile (%d, %d), perimeter=%d\n", X.row(), X.col(), islandPerimeter);
        }

        return islandPerimeter;
    }

    private void markSeenAndPush(int[] coordinates) {
        seaChart[coordinates[0]][coordinates[1]] = 2;
        this.coordinates.push(new Coordinate(coordinates));
    }

    private boolean isLandTile(int[] coordinates) {
        return seaChart[coordinates[0]][coordinates[1]] == 1;
    }

    private boolean isWaterTile(int[] coordinates) {
        return seaChart[coordinates[0]][coordinates[1]] == 0;
    }

//    private enum Dimension {
//        ROWS, COLUMNS;
//    }

//    private int processTile(int[] tile, Dimension dim) {
//        if(tile[dim.ordinal()] >= 0 && tile[dim.ordinal()] < getSizeOfSeachartDimension(dim)) {
//            if (isWaterTile(tile)) return 1;
//            else if(isLandTile(tile))markSeenAndPush(new Coordinate(tile));
//
//            return 0;
//        } else return 1;
//    }

//    private int getSizeOfSeachartDimension(Dimension dimension) {
//        return switch(dimension) {
//            case ROWS -> seaChart.length;
//            case COLUMNS -> seaChart[0].length;
//        };
//    }

    //#endregion

    //#region BruteForce

    /* Runtime: 11 ms, faster than 54.76% of Java online submissions for Island Perimeter.
     * Memory Usage: 61.6 MB, less than 74.73% of Java online submissions for Island Perimeter.
     */
    public static int getPerimeterBF(int[][] grid) {
        int islandPerimeter = 0;

        for(int r=0; r < grid.length; ++r) {
            for(int c=0; c < grid[0].length; ++c) {

                if(grid[r][c] == 1) {
                    if(r-1 >= 0) {
                        if(grid[r-1][c]==0) islandPerimeter += 1;
                    } else islandPerimeter +=1;

                    if(c+1 < grid[0].length) {
                        if(grid[r][c+1]==0) islandPerimeter += 1;
                    } else islandPerimeter +=1;

                    if(r+1 < grid.length) {
                        if(grid[r+1][c]==0) islandPerimeter += 1;
                    } else islandPerimeter +=1;

                    if(c-1 >= 0) {
                        if(grid[r][c-1]==0) islandPerimeter += 1;
                    } else islandPerimeter +=1;
                }
            }
        }

        return islandPerimeter;
    }

    //#endregion

    //#region LeetcodeResearch

    private int peremeter= 0;//calculating the peremeter, by traversing in 4 direction in search of water and boundary

    public int islandPerimeterL2(int[][] grid)
    {
        for(int i= 0; i< grid.length; i++)
        {
            for(int j= 0; j< grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    getIslandPerimeter(grid, i, j);//recursively calculates the peremeter of 1 island, we just need one node of that component
                    return peremeter;
                }
            }
        }
        return peremeter;
    }
    public void getIslandPerimeter(int [][]grid, int i, int j) {
        //Preorder, DFS (since we have to first mark as visit with -1, oherwise there will be a loop i.e; function calling each other)

        //BASE CASE
        if(i< 0 || j< 0 || i >= grid.length || j >= grid[0].length){
            peremeter+= 1;//when we hit a index out of bound means it is boundary(we are crossing a boundary) we add 1 to the peremeter
            return;
        }

        if(grid[i][j] == 0){//when we hit a zero means that there is a boundary between water and island
            peremeter+= 1;
            return;
        }

        if(grid[i][j] == -1)//already calculated the peremeter, do need to take tension
            return;

        //Only one island


        //ROOT
        grid[i][j]= -1;//marking the visited block of the component as -1, so that we dont traverse it more than once and it should not affect the peremeter


        //LEFT-RIGHT-TOP-BOTTOM
        getIslandPerimeter(grid, i-1, j);//Top
        getIslandPerimeter(grid, i, j+1);//Right
        getIslandPerimeter(grid, i, j-1);//Left
        getIslandPerimeter(grid, i+1, j);//Bottom


        //child is recursively bringing the peremeter from 4 direction
        //returning to the calling function

        //return;
    }

    //#endregion
}
