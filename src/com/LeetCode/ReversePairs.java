package com.LeetCode;

import java.util.ArrayList;
import java.util.Scanner;

public class ReversePairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int ans = reversePairs(nums);
        System.out.println(ans);
    }

    private static int reversePairs(int[] nums) {
        return mergesort(nums, 0, nums.length - 1);
        // calling merge sort with low, high params
    }
    private static int mergesort(int[] nums, int low, int high){
        if(low>=high) {
            // if it is a single element we will return 0 as it won't be contributing to the ans
            return 0;
        }
        int middle = (low+high)/2;
        // computing the mid for the merge sort
        int inversion = mergesort(nums, low, middle);
        // calling the left half via recursion i.e low to mid
        inversion += mergesort(nums, middle + 1, high);
        // calling the right half via recursion i.e mid+1 to high
        inversion += merge(nums, low, middle, high);
        // merging the 2 sorted arrays and returning the inverted pairs in int form

        return inversion;
        // returing the inversion pairs for every recursive call
    }
    private static int merge(int[] nums, int low, int middle, int high){
        int count = 0;
        int j = middle + 1;
        // initializing j at the starting position of the right half of the array
        for(int i= low; i <= middle; i++) {
            // iterate i in the left half of the array
            while(j <= high && nums[i] > (2 * (long) nums[j])) {
                // either right half is exausted or if condition in question turns out as false, keep incrementing the j pointer
                j++;
            }
            count += (j - (middle + 1));
            // counting the number of left elements (how much j has moved from initial mid+1)
        }

        // now we simply perform the merge function

        ArrayList<Integer> list = new ArrayList<>();
        int left = low;
        int right = middle + 1;
        while(left <= middle && right <= high) {
            if(nums[left] <= nums[right]) {
                // adding the smaller to the temp arraylist
                list.add(nums[left++]);
                // incrementing the index of the added element
            }
            else {
                list.add(nums[right++]);
                // adding and incrementing right if right is smaller
            }
        }
        while(left <= middle) {
            // if left part is left to be copied, we add it to the arraylist and increment index left
            list.add(nums[left++]);
        }
        while(right <= high) {
            // if right part is left to be copied, we add it to the arraylist and increment index right
            list.add(nums[right++]);
        }
        for(int i =low; i <= high; i++) {
            nums[i] = list.get(i - low);
            // copying the sorted arraylist to the original nums array
        }
        return count;
        // returning the total number of pairs
    }
}
