package io.coffeelessprogrammer.leetcode.medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class LongestSubstringNoRepeatingCharTests {

    @Test
    final void HappyPath() {
        Assertions.assertEquals(3, LongestSubstringNoRepeatingChar.getLength("abccabb"));
    }

    @Test
    final void Overlap() {
        Assertions.assertEquals(4, LongestSubstringNoRepeatingChar.getLength("abcbda"));
    }

    @Test
    final void EmptyString() {
        Assertions.assertEquals(0, LongestSubstringNoRepeatingChar.getLength(""));
    }

    @Test
    final void OneRepeatedChar() {
        Assertions.assertEquals(1, LongestSubstringNoRepeatingChar.getLength("ccccccc"));
    }

    @Test
    final void TrickyOverlap() {
        Assertions.assertEquals(5, LongestSubstringNoRepeatingChar.getLength("anviaj"));
    }
}