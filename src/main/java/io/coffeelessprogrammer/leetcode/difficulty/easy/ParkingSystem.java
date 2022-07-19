package io.coffeelessprogrammer.leetcode.difficulty.easy;

/*
 * Problem: 1603. Design Parking System
 * Acceptance Rate: 86.8%
 * URL: https://leetcode.com/problems/design-parking-system/
 *
 * Runtime: 6 ms, faster than 99.82% of Java online submissions for Design Parking System.
 * Memory Usage: 39.6 MB, less than 78.18% of Java online submissions for Design Parking System.
 */

public class ParkingSystem {

    private final int[] availableSpacesOfSize;

    public ParkingSystem(int big, int medium, int small) {
        this.availableSpacesOfSize = new int[4];
        this.availableSpacesOfSize[1] = big;
        this.availableSpacesOfSize[2] = medium;
        this.availableSpacesOfSize[3] = small;
    }

    public boolean addCar(int carType) {
        return --this.availableSpacesOfSize[carType] > -1;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
