package com.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindSumPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums1 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] nums2 = new int[m];
        for (int i = 0; i < m; i++) {
            nums2[i] = scanner.nextInt();
        }

    }

    // First Approach

//     HashMap<Integer, Integer> map1;
//     HashMap<Integer, Integer> map2;
//     int[] arr;

//     public FindSumPairs(int[] nums1, int[] nums2) {
//         map1 = new HashMap<>();
//         map2 = new HashMap<>();
//         arr = new int[nums2.length];
//         for(int i = 0; i < nums1.length; i++)
//             map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
//         for(int i = 0; i < nums2.length; i++)
//             map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
//         arr = nums2;
//     }

//     public void add(int index, int val) {
//         map2.put(arr[index], map2.get(arr[index]) - 1);
//         arr[index] += val;
//         map2.put(arr[index], map2.getOrDefault(arr[index], 0) + 1);
//     }

//     public int count(int tot) {
//         int ans = 0;
//         for(int key : map1.keySet()) {
//         	int tar = tot - key;
//         	ans += map1.get(key) * map2.getOrDefault(tar, 0);
//         }
//         return ans;
//     }


    // Second Approach

    Map<Integer, Integer> numFreq = new HashMap<>(); // nums2[i] -> freq
    int[] nums1, nums2; // we want the instance of arrays in add()
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for(int num : nums2) { // put all the num and the freq of num in nums2[] array in a hashmap
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        numFreq.put(nums2[index], numFreq.getOrDefault(nums2[index], 0) - 1); // since nums2[index] value needed to be updated, so dec freq
        nums2[index] += val;
        numFreq.put(nums2[index], numFreq.getOrDefault(nums2[index], 0) + 1); // add freq of newly created num
    }

    public int count(int tot) {
        int res = 0;
        for(int num : nums1) {
            res += numFreq.getOrDefault(tot - num, 0); // find in hashmap
        }

        return res;
    }


    // Third Approach
//     int[] nums1;
//     int[] nums2;
//     private HashMap<Integer,Integer> hash2 = new HashMap<>();
//     public FindSumPairs(int[] nums1, int[] nums2) {
//         this.nums1 = nums1;
//         this.nums2 = nums2;
//         for(int i : nums2){
//             int freq = (hash2.containsKey(i))?hash2.get(i)+1:1;
//             this.hash2.put(i,freq);
//         }
//     }

//     public void add(int index, int val) {
//         // this.hash2.remove(nums2[index]);
//         int oldFreq = hash2.get(nums2[index]);
//         if(oldFreq ==1){
//             hash2.remove(nums2[index]);
//         }
//         else{
//             hash2.replace(nums2[index],oldFreq-1);
//         }
//         this.nums2[index] += val;
//         int freq = (hash2.containsKey(nums2[index]))?hash2.get(nums2[index])+1:1;
//         if (freq == 1){
//             hash2.put(nums2[index], 1);
//         }
//         else{
//             hash2.replace(nums2[index], freq);
//         }


//         return;
//     }

//     public int count(int tot) {
//         int count =0;
//         for(int i : nums1){
//             if(this.hash2.containsKey(tot-i)){
//                 count+= hash2.get(tot-i);
//             }
//         }
//         return count;



//     }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
