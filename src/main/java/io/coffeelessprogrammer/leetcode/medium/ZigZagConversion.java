package io.coffeelessprogrammer.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem: 6. ZigZag Conversion
 * Acceptance Rate: 39.7%
 * URL: https://leetcode.com/problems/zigzag-conversion/
 *
 * Runtime: 8 ms, faster than 54.57% of Java online submissions for ZigZag Conversion.
 * Memory Usage: 39.4 MB, less than 77.06% of Java online submissions for ZigZag Conversion.
 *
 *   ↓ After Optimization
 *
 * Runtime: 2 ms, faster than 99.95% of Java online submissions for ZigZag Conversion.
 * Memory Usage: 38.9 MB, less than 97.86% of Java online submissions for ZigZag Conversion.
 */

public class ZigZagConversion {
    private static List<StringBuilder> rows;

    public static String fmtHrzCompactOptimized(String str, int numRows) {
        if(numRows < 2 || numRows >= str.length()) return str;

        final int distanceBetween = 2*numRows - 2;    // indicesBetweenCharsOfSamePosition

        StringBuilder result = new StringBuilder();

        for(int i=0; i < str.length(); i += distanceBetween) {
            result.append(str.charAt(i));
        }

        for(int i=1; i < numRows-1; ++i) {
            for(int left = i, right = distanceBetween - i; left < str.length();left += distanceBetween, right += distanceBetween) {
                result.append(str.charAt(left));

                if(right < str.length())
                    result.append(str.charAt(right));
                else break;
            }
        }

        for(int i=numRows-1; i < str.length(); i += distanceBetween) {
            result.append(str.charAt(i));
        }

        return result.toString();
    }

    public static String formatHorizontalCompact(String str, int numRows) {
        if(numRows < 2 || numRows >= str.length()) return str;

        initRows(numRows);

        boolean descending = true;

        int currentRow = 0;

        for(int i=0; i < str.length(); ++i) {
            rows.get(currentRow).append(str.charAt(i));

            if(descending) {
                ++currentRow;

                if(currentRow == numRows) {
                    currentRow -= 2;
                    descending = false;
                }
            }
            else {
                --currentRow;

                if(currentRow < 0) {
                    currentRow += 2;
                    descending = true;
                }
            }
        }

        return String.join("", rows);
    }

    public static String formatHorizontal(String str, int numRows) {
        if(numRows < 2 || numRows >= str.length()) return str;

        final String doubleSpace = "  ";
        final int indicesBetweenCharsOfSamePosition = 2*numRows - 2;
        final int spacesOffset = numRows%2 == 0 ? Math.max((int) Math.ceil(numRows / 2.0), 2) : numRows-2;

        initRows(str, numRows);

        boolean goingDown = false;
        int currPosition;
        StringBuilder currRow;

        for(int i=numRows; i < str.length(); ++i) {
            currPosition = i%indicesBetweenCharsOfSamePosition;

            if(goingDown) {
                currRow = rows.get(currPosition);
                currRow.append(doubleSpace.repeat(currPosition-1)).append(" ").append(str.charAt(i));

                if(currPosition == indicesBetweenCharsOfSamePosition/2) goingDown = false;
            }
            else {
                currRow = rows.get((indicesBetweenCharsOfSamePosition - currPosition)%indicesBetweenCharsOfSamePosition);
                currRow.append(doubleSpace.repeat((currPosition+spacesOffset)%indicesBetweenCharsOfSamePosition)).append(" ").append(str.charAt(i));

                if(currPosition == 0) goingDown = true;
            }
        }

        return String.join("\n", rows);
    }

    public static String formatHorizontalVerbose(String str, int numRows) {
        if(numRows < 2 || numRows >= str.length()) return str;

        final String doubleSpace = "  ";
        // final int centralRowCount = numRows-2;
        // final boolean isNumRowsEven = numRows%2 == 0;
        final int indicesBetweenCharsOfSamePosition = 2*numRows - 2;
        final int spacesOffset = numRows%2 == 0 ? Math.max((int) Math.ceil(numRows / 2.0), 2) : numRows-2;

        initRows(str, numRows);

        System.out.println("IndicesBetweenCharsOfSamePosition: " + indicesBetweenCharsOfSamePosition + "\n");

        boolean goingDown = false;
        int currPosition;
        StringBuilder currRow;

        System.out.println("  Start:\n" + String.join("\n", rows));

        for(int i=numRows; i < str.length(); ++i) {
            currPosition = i%indicesBetweenCharsOfSamePosition;

            System.out.println("\ni: " + i + " (" + str.charAt(i) + ")" + "   i%indicesBetweenCharsOfSamePosition: " + i%indicesBetweenCharsOfSamePosition);

            if(goingDown) {
                System.out.println("  Descending");
                currRow = rows.get(currPosition);
                currRow.append(doubleSpace.repeat(currPosition-1)).append(" ").append(str.charAt(i));

                if(currPosition == indicesBetweenCharsOfSamePosition/2) goingDown = false;
            }
            else {
                System.out.println("  Ascending");
                System.out.println("\tGet row: " + ((indicesBetweenCharsOfSamePosition - currPosition)%indicesBetweenCharsOfSamePosition) + "   Repeat spaces: " + ((i%indicesBetweenCharsOfSamePosition+2)%indicesBetweenCharsOfSamePosition));
                currRow = rows.get((indicesBetweenCharsOfSamePosition - currPosition)%indicesBetweenCharsOfSamePosition);
                currRow.append(doubleSpace.repeat((currPosition+spacesOffset)%indicesBetweenCharsOfSamePosition)).append(" ").append(str.charAt(i));

                if(currPosition == 0) goingDown = true;
            }

            System.out.println("\t  Append letter:\n" + String.join("\n", rows));
        }

        return String.join("\n", rows);
    }

    // #region Helpers

    private static void initRows(String str, int numRows) {
        rows = new ArrayList<>();

        for(int i=0; i < numRows; ++i) {
            rows.add(new StringBuilder());
            rows.get(i).append(str.charAt(i));
        }
    }

    private static void initRows(int numRows) {
        rows = new ArrayList<>();

        for(int i=0; i < numRows; ++i) {
            rows.add(new StringBuilder());
        }
    }

    // #endRegion
}
