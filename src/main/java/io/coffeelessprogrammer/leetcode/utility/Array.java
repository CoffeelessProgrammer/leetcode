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

    public static void swapIndices(char[] arr, int m, int n) {
        if(m >= arr.length || n >= arr.length)
            throw new IllegalArgumentException("Indice(s) exceed array bounds.");
        if(m==n) return;

        char temp = arr[n];
        arr[n] = arr[m];
        arr[m] = temp;
    }

    public static void reverseSegment(char[] arr, int start, int end) {
        if(start >= arr.length || end >= arr.length)
            throw new IllegalArgumentException("Indice(s) exceed array bounds.");
        if(start==end) return;

        char temp;

        for(; start < end; ++start, --end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
}
