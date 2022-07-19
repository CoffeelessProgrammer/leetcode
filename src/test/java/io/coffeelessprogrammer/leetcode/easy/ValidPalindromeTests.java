package io.coffeelessprogrammer.leetcode.easy;

import io.coffeelessprogrammer.leetcode.difficulty.easy.ValidPalindrome;
import io.coffeelessprogrammer.leetcode.difficulty.easy.ValidPalindromeII;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ValidPalindromeTests {

    // #region ValidPalindrome

    @Test
    final void EvenLength_Melon() {
        Assertions.assertTrue(ValidPalindrome.isPalindrome("No lemon, no melon"));
    }

    @Test
    final void OddLength_Panama() {
        Assertions.assertTrue(ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }

    // #endRegion

    // #region ValidPalindromeII

    private final ValidPalindromeII vp2 = new ValidPalindromeII();

    @Test
    final void Odd_ABC() {
        Assertions.assertTrue(vp2.isAlmostPalindrome("abccdba", 1));
    }

    @Test
    final void Even_Racecar() {
        Assertions.assertTrue(vp2.isAlmostPalindrome("raceacar", 1));
    }

    @Test
    final void False() {
        Assertions.assertFalse(vp2.isAlmostPalindrome("abcdefdba", 1));
    }

    @Test
    final void True_Remove2() {
        Assertions.assertTrue(vp2.isAlmostPalindrome("abcdefdba", 2));
    }

    // #endRegion

}
