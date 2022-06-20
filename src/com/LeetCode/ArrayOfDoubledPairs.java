package com.LeetCode;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ArrayOfDoubledPairs {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        */
        int[] arr = {4, -2, 2, -4};
        boolean ans = canReorderDoubled(arr);
        System.out.println(ans);
    }
    private static boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int element : arr) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        for (int element : map.keySet()) {
            if (map.get(element) == 0) {
                continue;
            }
            int target = element < 0 ? element / 2 : element * 2;
            if (element < 0 && element % 2 != 0) {
                return false;
            }
            if (map.get(element) > map.getOrDefault(target, 0)) {
                return false;
            }
            map.put(target, map.get(target) - map.get(element));
        }
        return true;
    }
}
