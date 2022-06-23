package io.coffeelessprogrammer.leetcode;

import io.coffeelessprogrammer.leetcode.twopointers.stringreversal.ReverseVowelsOfString;
import io.coffeelessprogrammer.leetcode.twopointers.stringreversal.ReverseWordsInString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringReversalTests {

    //#region ReverseWordsInString

    @Test
    final void ReverseWords_HappyPath() {
        assertEquals("blue is sky the", ReverseWordsInString.reverse("the sky is blue"));
    }

    @Test
    final void ReverseWords_LeadingTrailingSpaces() {
        assertEquals("world hello", ReverseWordsInString.reverse("  hello world  "));
    }

    @Test
    final void ReverseWords_MultipleSpacesBetween() {
        assertEquals("example good a", ReverseWordsInString.reverse("a good   example"));
    }

    //#endRegion

    //#region ReverseVowelsOfString

    @Test
    final void ReverseVowels_VowelDictionary_Hello() {
        assertEquals("holle", ReverseVowelsOfString.reverseViaVowelDictionary("hello"));
    }

    @Test
    final void ReverseVowels_VowelDictionary_Leetcode() {
        assertEquals("leotcedE", ReverseVowelsOfString.reverseViaVowelDictionary("lEetcode"));
    }

    @Test
    final void ReverseVowels_Leetcode() {
        assertEquals("leotcedE", ReverseVowelsOfString.reverse("lEetcode"));
    }

    //#endRegion
}
