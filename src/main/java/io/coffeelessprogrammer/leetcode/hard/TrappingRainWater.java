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

    /** In progress */
    public static int calcVolumeBF(int[] walls) {
        int totalTrappedWater = 0;

        List<Integer> waterTrappedPerLevel;

        for(int i=1; i < walls.length; ++i) {
            if(walls[i] > 0) {
                waterTrappedPerLevel = new ArrayList<>();

                for(int j=i+1; j < walls.length && walls[j] < walls[i]; ++j) {

                    System.out.println(waterTrappedPerLevel.size());
                    for(int k=1; k < walls[i]; ++k) {
                        waterTrappedPerLevel.add(walls[i] - walls[j]);
                    }
                }

                System.out.println(Arrays.toString(waterTrappedPerLevel.toArray()));

                for(int volumeAtDepth: waterTrappedPerLevel) {
                    totalTrappedWater += volumeAtDepth;
                }
            }
        }

        return totalTrappedWater;
    }
}
