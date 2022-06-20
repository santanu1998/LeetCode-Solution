package com.GeeksForGeeks.Array;

public class CountInversions {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long[] arr = new long[(int) n];
        for (int i = 0; i < (int) n; i++) {
            arr[i] = scanner.nextLong();
        }
        */
        long[] arr = {2, 4, 1, 3, 5};
        long ans = inversionCount(arr, arr.length);
        System.out.println(ans);
    }

    // Using Merge Sort
    private static long inversionCount(long[] arr, long N)
    {
        long[] temp = new long[(int)N];
        long result = mergeSort(arr, temp, 0, arr.length - 1);
        return result;

    }
    private static long mergeSort(long[] arr, long[] temp, long left, long right) {
        long mid, invCount = 0;
        if(right > left) {
            mid = (right + left) / 2;
            invCount += mergeSort(arr, temp, left, mid);
            invCount += mergeSort(arr, temp, mid + 1, right);
            invCount += merge(arr, temp, left, mid + 1, right);
        }
        return invCount;
    }
    private static long merge(long[] arr, long[] temp, long left, long mid, long right) {
        long invCount = 0;
        int i, j, k;
        i = (int) left;
        j = (int) mid;
        k = (int) left;
        while((i <= mid - 1) && (j <= right)) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
                invCount = invCount + (mid - i);
            }
        }
        while(i <= mid - 1) {
            temp[k++] = arr[i++];
        }
        while(j <= right) {
            temp[k++] = arr[j++];
        }
        for(i = (int)left; i <= (int)right; i++) {
            arr[i] = temp[i];
        }
        return invCount;
    }
    // Time Complexity is : O(n(log n))
    // Auxiliary Space Complexity is : O(n)
}
