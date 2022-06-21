package io.coffeelessprogrammer.leetcode.utility;

public class Array {

    public static void swapIndices(int[] arr, int m, int n) {
        if(m >= arr.length || n >= arr.length)
            throw new IllegalArgumentException("Indice(s) exceed array bounds.");
        if(m==n) return;

        arr[n] -= arr[m];
        arr[m] += arr[n];
        arr[n] = arr[m] - arr[n];
    }
}
