package io.coffeelessprogrammer.leetcode.medium;

/*
 * Problem: 11. Container With Most Water
 * Acceptance Rate: 53.1%
 * URL: https://leetcode.com/problems/container-with-most-water/
 *
 * Runtime: 2 ms, faster than 98.48% of Java online submissions for Container With Most Water.
 * Memory Usage: 52.5 MB, less than 78.23% of Java online submissions for Container With Most Water.
 */

public class ContainerWithMostWater {

    public static int calcMaxArea(int[] heights) {
        int currentArea,
                maxArea=0,
                i=0,
                j= heights.length-1;

        while(i < j) {
            currentArea = Math.min(heights[i], heights[j]) * (j-i);
            if(currentArea > maxArea) maxArea = currentArea;

            if(heights[i] <= heights[j]) ++i;
            else --j;
        }

        return maxArea;
    }

    public static int calcMaxAreaBF(int[] heights) {
        // if(heights.length < 2) return 0;

        int maxArea = 0, currentArea;

        for(int i=0; i < heights.length-1; ++i) {
            // System.out.println("Max Area: " + maxArea);

            for(int j=i+1; j < heights.length; ++j){
                currentArea = Math.min(heights[i], heights[j]) * (j-i);
                // System.out.println("Current Area: " + Math.min(height[i], height[j]) + " H x " + (j-i) + " W = " + currentArea);

                if(currentArea > maxArea) {
                    maxArea = currentArea;
                    // System.out.println("  New Max: " + maxArea);
                }
            }
        }

        return maxArea;
    }
}
