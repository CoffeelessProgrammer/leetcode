package io.coffeelessprogrammer.leetcode.utility;

import java.util.List;

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

        while(start < end) {
            temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for(int num : arr) sum += num;
        return sum;
    }

    public static int getMax(List<Integer> integers) {
        int max = 0;
        for(int num : integers) if(num > max) max = num;
        return max;
    }
}
