package com.GeeksForGeeks.Array;

import java.io.*;
import java.lang.*;

public class MinAndMaxInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
        long[] arr = new long[(int) n];
        String[] inputLine = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(inputLine[i]);
        }
        pair product = getMinMax(arr);
        System.out.println(product.first + " " + product.second);
    }

    private static pair getMinMax(long[] arr) {
        long max = 0;
        long min = Long.MAX_VALUE;
        for (long l : arr) {
            if (l > max)
                max = l;
            if (l < min)
                min = l;
        }
        return new pair(min, max);
    }
}
class pair {
    long first, second;

    public pair(long first, long second) {
        this.first = first;
        this.second = second;
    }
}
