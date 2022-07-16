package io.coffeelessprogrammer.leetcode;

import io.coffeelessprogrammer.leetcode.graphsearch.IslandPerimeter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IslandPerimeterTests {

    IslandPerimeter islandPerimeter = new IslandPerimeter();

    @Test
    final void IslandPerimeter_HappyPath() {
        assertEquals(16, islandPerimeter.getPerimeter(new int[][]{{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}}));
    }

    @Test
    final void IslandPerimeterBF_HappyPath() {
        assertEquals(16, IslandPerimeter.getPerimeterBF(new int[][]{{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}}));
    }

    @Test
    final void IslandPerimeterOptimized_HappyPath() {
        assertEquals(16, IslandPerimeter.calculate(new int[][]{{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}}));
    }
}
