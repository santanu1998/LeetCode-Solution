package com.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays2 {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = scanner.nextInt();
        }
        */
        int[] arr1 = {4,9,5};
        int[] arr2 = {9,4,9,8,4};
        int[] result = intersection(arr1, arr2);
        for(int element : result) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums2){
            if(map.containsKey(i)){
                map.put(i,map.get(i) + 1);
            }
            else{
                map.put(i,1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i : nums1){
            if(map.containsKey(i) && map.get(i) > 0){
                map.put(i,map.get(i) - 1);
                res.add(i);
            }
        }
        int[] ans = new int[res.size()];
        for(int i = 0;i < res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
