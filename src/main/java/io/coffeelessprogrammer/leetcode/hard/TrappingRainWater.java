package io.coffeelessprogrammer.leetcode.hard;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/*
 * Problem: 42. Trapping Rain Water
 * Acceptance Rate: 53.7%
 * URL: https://leetcode.com/problems/trapping-rain-water/
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Trapping Rain Water.
 * Memory Usage: 38.4 MB, less than 91.31% of Java online submissions for Trapping Rain Water.
 */

public class TrappingRainWater {

    public static int calcVolume(int[] walls) {
        int totalTrappedWater = 0;

        int pL = 0, pR = walls.length-1;

        int highestLeftWallHeightFound=0, highestRightWallHeightFound=0;

        while(pR > pL) {

            if(walls[pL] <= walls[pR]) {
                if(walls[pL] < highestLeftWallHeightFound){
                    totalTrappedWater += highestLeftWallHeightFound-walls[pL];
                } else {
                    highestLeftWallHeightFound = walls[pL];
                }

                ++pL;
            }
            else {  // walls[pR] < walls[pL]
                if(walls[pR] < highestRightWallHeightFound){
                    totalTrappedWater += highestRightWallHeightFound-walls[pR];
                } else {
                    highestRightWallHeightFound = walls[pR];
                }

                --pR;
            }
        }

        return totalTrappedWater;
    }

    // #region BruteForce

    public static int calcVolumeBF(int[] walls) {
        int totalTrappedWater = 0;

        for(int i=0; i < walls.length; ++i) {
            int maxLeft = findHeightTallestLeftWall(walls, i);
            int maxRight = findHeightTallestRightWall(walls, i);

            int currentWater = Math.min(maxLeft, maxRight) - walls[i];

            if(currentWater > 0)
                totalTrappedWater += currentWater;
        }

        return totalTrappedWater;
    }

    private static int findHeightTallestLeftWall(int[] walls, int startingIndex) {
        int tallestWall = 0;

        for(int i=startingIndex; i > -1; --i) {
            tallestWall = Math.max(walls[i], tallestWall);
        }

        return tallestWall;
    }

    private static int findHeightTallestRightWall(int[] walls, int startingIndex) {
        int tallestWall = 0;

        for(int i=startingIndex; i < walls.length; ++i) {
            tallestWall = Math.max(walls[i], tallestWall);
        }

        return tallestWall;
    }

    // #endRegion
}
