package com.GeeksForGeeks.Array;

public class PalindromicArray {
    public static void main(String[] args) {
        int[] arr = {111, 222, 333, 444, 555};
        int n = arr.length;
        int answer = palintArray(arr, n);
        System.out.println(answer);
    }
    private static int palintArray(int[] a, int n) {
        for(int i = 0; i < n; i++){
            String sb0 = Integer.toString(a[i]);
            int len = sb0.length();
            for(int j = 0; j < len/2; j++){
                if(sb0.charAt(j)!=sb0.charAt(len-j-1)){
                    return 0;
                }
            }
        }
        return 1;
    }
}
