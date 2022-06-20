package com.GeeksForGeeks.Array;

public class MinimumSwapsAndKTogether {
    public static void main(String[] args) {
        int[] arr = {2, 7, 9, 5, 8, 7, 4};
        int n = arr.length;
        int k = 6;
        int answer = minSwap(arr, n, k);
        System.out.println(answer);
    }
    private static int minSwap (int[] arr, int n, int k) {
        /*//Complete the function

        int count=0;

        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]<=k)
                count++;
        }
        for(int i=0;i<=n-count;i++){
            int ccount=0;
            for(int j=i;j<i+count;j++){
                if(arr[j]>k)
                    ccount++;
            }
            ans=Math.min(ans,ccount);
        }
        return ans;*/

        int favourable = 0;
        int nonFavourable = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                favourable++;
            }
        }
        for (int j = 0; j < favourable; j++) {
            if (arr[j] > k) {
                nonFavourable++;
            }
        }
        int low = 0;
        int high = favourable - 1;
        int answer = Integer.MAX_VALUE;
        while (high < n) {
            answer = Math.min(answer, nonFavourable);
            high++;
            if (high < n && arr[high] > k) {
                nonFavourable++;
            }
            if (low < n && arr[low] > k) {
                nonFavourable--;
            }
            low++;
        }
        return (answer == Integer.MAX_VALUE) ? 0 : answer;
    }
}
