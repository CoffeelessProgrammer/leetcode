package io.coffeelessprogrammer.leetcode.easy;

import io.coffeelessprogrammer.leetcode.difficulty.easy.LengthOfLastWord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthOfLastWordTests {

    @Test
    final void HelloWorld_5() {
        assertEquals(5, LengthOfLastWord.find("Hello World"));
    }

    @Test
    final void HelloWorld_5_TrailingSpaces() {
        assertEquals(5, LengthOfLastWord.find("Hello World  "));
    }

    @Test
    final void HelloWorld_5_LeadingSpaces() {
        assertEquals(5, LengthOfLastWord.find("  Hello World  "));
    }
}
