package com.GeeksForGeeks.Array;

public class SortTheArrayOfZero {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        */
        int[] arr = {0, 2, 0, 1, 0, 1, 2, 1, 1, 0};
        sort012(arr);
        printArray(arr);
    }
    public static void sort012(int[] arr)
    {
        int low = 0, high = arr.length - 1, mid = 0;
        while(mid <= high){
            if(arr[mid]==0) {
                int temp=arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;
                low++;
                mid++;
            } else if(arr[mid]==1) {
                mid++;
            } else {
                int temp=arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high--;
            }
        }
    }
    private static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
