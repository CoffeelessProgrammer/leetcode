package io.coffeelessprogrammer.leetcode.twopointers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Problem: 20. Valid Parentheses
 * Difficulty: Easy
 * Acceptance Rate: 99.9%
 * URL: https://leetcode.com/problems/binary-search/
 *
 * Runtime:
 * Memory Usage:
 */
public class ValidParentheses {
    private static final Map<Character, Character> bracketPairs = new HashMap<>();
    private static final Set<Character> closingBrackets = new HashSet<>();
    private static final Set<Character> openingBrackets = new HashSet<>();

    static {
        bracketPairs.put(')', '(');
        bracketPairs.put(']', '[');
        bracketPairs.put('}', '{');

        openingBrackets.add('(');
        openingBrackets.add('[');
        openingBrackets.add('{');

        closingBrackets.add(')');
        closingBrackets.add(']');
        closingBrackets.add('}');
    }

    public boolean isValid(String s) {
        for(int left=0, i=1; i < s.length(); ++i) {

        }
        return true;
    }

    private boolean isSubexpressionValid(String s, int start) {
        for(int left=start, i=start+1; left >= start; ++i) {

        }

        return true;
    }

    private static boolean isClosingBracket(char c) {
        return closingBrackets.contains(c);
    }

    private static boolean isOpeningBracket(char c) {
        return openingBrackets.contains(c);
    }
}
