package com.LeetCode;

import java.util.Scanner;

public class SortColors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        sortColors(nums);
        printArray(nums);
    }
    private static void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        mergeSort(nums, low, high);
    }
    private static void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(nums, low, middle);
            mergeSort(nums, middle + 1, high);
            merge(nums, low, middle, high);
        }
    }

    private static void merge(int[] nums, int low, int middle, int high) {
        int length1 = middle - low + 1;
        int length2 = high - middle;
        int[] left = new int[length1];
        int[] right = new int[length2];
        for (int i = 0; i < length1; ++i) {
            left[i] = nums[low + i];
        }
        for (int j = 0; j < length2; ++j) {
            right[j] = nums[middle + 1 + j];
        }
        int i = 0, j = 0, k = low;
        while (i < length1 && j < length2) {
            if (left[i] <= right[j]) {
                nums[k] = left[i];
                i++;
            }
            else {
                nums[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < length1) {
            nums[k] = left[i];
            i++;
            k++;
        }
        while (j < length2) {
            nums[k] = right[j];
            j++;
            k++;
        }
    }
    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
