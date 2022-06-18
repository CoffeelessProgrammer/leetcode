package io.coffeelessprogrammer.leetcode.binarysearch;

import java.util.Random;

import static io.coffeelessprogrammer.leetcode.binarysearch.BinarySearch.*;

/*
 * Problem: 278. First Bad Version
 * Difficulty: Easy
 * Acceptance Rate: 42.0%
 * URL: https://leetcode.com/problems/first-bad-version/
 *
 * Runtime: 14 ms, faster than 97.67% of Java online submissions for First Bad Version.
 * Memory Usage: 38.9 MB, less than 94.22% of Java online submissions for First Bad Version.
 */
public class FirstBadVersion {
    private static final Random rand = new Random();
    private static int firstBadVersion;

    private static boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }

    public static int search(int numVersions) {
        final int badVersionsStartingIndex = rand.nextInt(numVersions)+1;

        System.out.printf("Bad versions start at version %d\n", badVersionsStartingIndex);
        return search(numVersions, badVersionsStartingIndex);
    }

    public static int search(int numVersions, int badVersionsStartingIndex) {
        firstBadVersion = badVersionsStartingIndex;

        // Sanitize input
        if(isBadVersion(1)) return 1;
        if(!isBadVersion(numVersions)) return 0;

        // Set windows
        int leftBound = 2;
        int rightBound = numVersions;

        int position = BinarySearch.middleIndex(leftBound, rightBound);

        displayWindowCenter(position, leftBound, rightBound);

        boolean currentVersionBad, precedingVersionGood;

        do {

            currentVersionBad = isBadVersion(position);
            precedingVersionGood = !isBadVersion(position-1);

            if(currentVersionBad) {
                if(precedingVersionGood) break;

                if(isBadVersion(leftBound)) {
                    if(!isBadVersion((leftBound-1))) {
                        position = leftBound;
                        break;
                    }
                }

                leftBound += 1;
                rightBound = position-1;
                position = BinarySearch.middleIndex(leftBound, rightBound);

            } else {    // Current version is good
                if(isBadVersion(rightBound)) {
                    if(!isBadVersion((rightBound-1))) {
                        position = rightBound;
                        break;
                    }
                }

                leftBound = position+1;
                rightBound -= 1;
                position = BinarySearch.middleIndex(leftBound, rightBound);
            }

        } while(leftBound <= rightBound);

        return position;
    }

    public static int searchMinimalApiCalls(int numVersions, int badVersionsStartingIndex) {
        firstBadVersion = badVersionsStartingIndex;

        // Sanitize input
        if(isBadVersion(1)) return 1;
        if(!isBadVersion(numVersions)) return 0;
        if(!isBadVersion(numVersions-1)) return numVersions;

        // Set windows
        int leftBound = 2;
        int rightBound = numVersions;

        int position = middleIndex(leftBound, rightBound);

        displayWindowCenter(position, leftBound, rightBound);

        boolean currentVersionBad, precedingVersionGood;

        do {
            // position = BinarySearch.middleIndex(leftBound, rightBound);

            currentVersionBad = isBadVersion(position);
            precedingVersionGood = !isBadVersion(position-1);

            if(currentVersionBad) {
                if(precedingVersionGood) break;
                rightBound = position;
                position = BinarySearch.middleIndex(leftBound, rightBound);

                displayWindowLeft(position, leftBound, rightBound);
            }
            else {
                leftBound = position;
                position = BinarySearch.middleIndex(leftBound, rightBound);

                displayWindowRight(position, leftBound, rightBound);
            }

        } while(leftBound <= rightBound);

        return position;
    }

    public static int middleIndex(int leftBound, int rightBound) {
        return rightBound - (int) Math.ceil((rightBound-leftBound)/2.0);
    }

    //#region LeetcodeResearch

    public static int searchOptimal(int numVersions, int badVersionsStartingIndex) {
        firstBadVersion = badVersionsStartingIndex;

        int left=1, right = numVersions;
        int mid;

        while (left<right){
            mid = left+(right-left)/2;

            if(isBadVersion(mid))
                right = mid;
            else
                left = mid+1;
        }

        return left;
    }

    //#endRegion
}
