package com.LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class BeautifulArrangementII {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        */
        int n = 3;
        int k = 2;
        int[] result = constructArray(n, k);
        System.out.println(Arrays.toString(result));
    }
    private static int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int high = n;
        int low = 1;
        int index = 0;
        result[index++] = low++;
        boolean flag = false;
        while (k > 1) {
            result[index++] = high--;
            k--;
            flag = true;
            if (k > 1) {
                result[index++] = low++;
                k--;
                flag = false;
            }
        }
        while (index < n) {
            if (flag) {
                result[index++] = high--;
            }
            else {
                result[index++] = low++;
            }
        }
        return result;
    }
}
