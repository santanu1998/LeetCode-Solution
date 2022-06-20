package com.GeeksForGeeks.Array;

public class MoveAllNegativeNumbers {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        */
        int[] arr = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
        moveAllNegative(arr);
        printArray(arr);
    }

    // 1. Using Partitioning Method
    /*
    private static void moveAllNegative(int[] arr) {
        int j = 0;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if(i != j) {
                    *//*
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    *//*
                    swap(arr, i, j);
                }
                j++;
            }
        }

        // Time Complexity of this solution is : O(n)
        // Auxiliary Space Complexity of this solution is : O(1)
    }
    */

    // 2. Two Pointer Method

    private static void moveAllNegative(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            if (arr[left] < 0 && arr[right] < 0) {
                left++;
            }
            else if (arr[left] > 0 && arr[right] < 0) {
                /*
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                */
                swap(arr, left, right);
                left++;
                right--;
            }
            else if (arr[left] > 0 && arr[right] > 0) {
                right--;
            }
            else {
                left++;
                right--;
            }
        }

        // Time Complexity of this solution is : O(n)
        // Auxiliary Space Complexity of this solution is : O(1)
    }

    // 3. Dutch National Flag Algorithm
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /*public static void moveAllNegative(int[] ar)
    {
        int low = 0;
        int high = ar.length - 1;
        while (low <= high) {
            if (ar[low] <= 0)
                low++;
            else
                swap(ar, low, high--);
        }
    }*/

    private static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
