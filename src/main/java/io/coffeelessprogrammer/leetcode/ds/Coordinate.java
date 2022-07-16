package io.coffeelessprogrammer.leetcode.ds;

public record Coordinate(int row, int col) {

    public Coordinate(int[] coordinates) {
        this(coordinates[0], coordinates[1]);
    }

    public int x() { return this.row; }

    public int y() { return this.col; }
}
