package com.GeeksForGeeks.Array;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int size = arr.length;
        int value = 0;
        int answer = peakElement(arr, size);

        if(answer < 0 && answer >= size)
            System.out.println(0);
        else {
            if (size == 1 && answer == 0) {
                value = 1;
            }
            else if (answer == 0 && arr[0] >= arr[1]) {
                value = 1;
            }
            else if (answer == size - 1 && arr[size - 1] >= arr[size - 2]) {
                value = 1;
            }
            else if (answer >= 0 && answer < size && arr[answer] >= arr[answer + 1] && arr[answer] >= arr[answer - 1]) {
                value = 1;
            }
            else {
                value = 0;
            }
            System.out.println(value);
        }
    }
    private static int peakElement(int[] arr,int n) {
        if(n == 1 || arr[0] > arr[1]){
            return 0;
        }
        if(arr[n-1] > arr[n-2]) {
            return n - 1;
        }
        for(int i=1;i<n-1;){
            if(arr[i]>arr[i+1]) {
                if(arr[i-1]<arr[i]) {
                    return i;
                }
                else {
                    i+=2;
                }
            }
            else {
                i++;
            }

        }
        return -1;
    }
}
