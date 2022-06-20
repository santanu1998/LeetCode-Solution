package com.GeeksForGeeks.Array;

import java.util.HashSet;

public class ArraySubsetOfAnotherArray {
    public static void main(String[] args) {
        long[] a1 = {11, 1, 13, 21, 3, 7};
        long[] a2 = {11, 3, 7, 1};
        long n = a1.length;
        long m = a2.length;
        String ans = isSubset(a1, a2, n, m);
        System.out.println(ans);
    }
    private static String isSubset(long[] a1, long[] a2, long n, long m) {
        HashSet<Long> hashSet = new HashSet<>();
        int a = 0;
        for(long i = 0; i < n; i++){
            if(hashSet.contains(a1[(int)i])){
                a++;
            }
            hashSet.add(a1[(int)i]);
        }
        for(long i = 0; i < m; i++){
            hashSet.add(a2[(int)i]);
        }

        if(hashSet.size() + a == n) {
            return "Yes";
        }
        else {
            return "No";
        }
    }
}
