package io.coffeelessprogrammer.leetcode.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BackspaceStringCompareTests {

    @Test
    final void HappyPath() {
        Assertions.assertTrue(BackspaceStringCompare.compare("ab#c", "ad#c"));
    }

    @Test
    final void EmptyStrings() {
        Assertions.assertTrue(BackspaceStringCompare.compare("ab##", "c#d#"));
    }

    @Test
    final void DoubleHash() {
        Assertions.assertTrue(BackspaceStringCompare.compare("a##c", "#a#c"));
    }

    @Test
    final void Unequal() {
        Assertions.assertFalse(BackspaceStringCompare.compare("a#c", "b"));
    }

    @Test
    final void HashesPhrase() {
        Assertions.assertTrue(BackspaceStringCompare.compare("bxj##tw", "bxo#j##tw"));
    }
}

