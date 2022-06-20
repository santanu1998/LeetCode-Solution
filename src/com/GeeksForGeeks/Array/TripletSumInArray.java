package com.GeeksForGeeks.Array;

import java.util.Arrays;
import java.util.HashSet;

public class TripletSumInArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int n = arr.length;
        int sum = 13;
        boolean ans = find3Numbers(arr, n, sum);
        System.out.println(ans ? 1 : 0);
    }

    // 1. Using Sorting
    // Time Complexity of this solution is : O(n^2)
    // Auxiliary Space Complexity of this solution is : O(1)

    /*private static boolean find3Numbers(int[] A, int n, int X) {
        Arrays.sort(A);
        for(int i = 0; i < n; i++){
            int a = i + 1;
            int b = n - 1;
            while(a < b){
                if(A[i] + A[a] + A[b] < X){
                    a++;
                }
                else if(A[i] + A[a] + A[b] > X){
                    b--;
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }*/

    // 2. Using HashSet
    // Time Complexity of this solution is : O(n^2)
    // Auxiliary Space Complexity of this solution is : O(1)

    private static boolean find3Numbers(int[] A, int n, int X) {
        for (int i = 0; i < n - 2; i++) {
            HashSet<Integer> mySet = new HashSet<>();
            int toFindTheNumber = X - A[i];
            for (int j = i + 1; j < n; j++) {
                if (mySet.contains(toFindTheNumber - A[j])) {
                    return true;
                }
                mySet.add(A[j]);
            }
        }
        return false;
    }
}
