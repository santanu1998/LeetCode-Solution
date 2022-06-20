package com.GeeksForGeeks;

import java.util.Arrays;

public class RearrangeArrayInAlternatingPositiveAndNegativeItemsWithExtraSpace {

    // 1. Naive Approach
    // Time Complexity of this solution is : O(n^2)
    // Auxiliary Space Complexity of this solution is : O(1)

    /*private static void rightRotate(int[] arr, int n, int outOfPlace, int cur) {
        int tmp = arr[cur];
        for (int i = cur; i > outOfPlace; i--) {
            arr[i] = arr[i - 1];
        }
        arr[outOfPlace] = tmp;
    }

    private static void rearrange(int[] arr, int n) {
        int outOfPlace = -1;

        for (int index = 0; index < n; index++)
        {
            if (outOfPlace >= 0)
            {
                // find the item which must be moved into
                // the out-of-place entry if out-of-place
                // entry is positive and current entry is
                // negative OR if out-of-place entry is
                // negative and current entry is negative
                // then right rotate
                //
                // [...-3, -4, -5, 6...] -->   [...6, -3,
                // -4, -5...]
                //      ^                          ^
                //      |                          |
                //     outofplace      -->      outofplace
                //
                if (((arr[index] >= 0)
                        && (arr[outOfPlace] < 0))
                        || ((arr[index] < 0)
                        && (arr[outOfPlace] >= 0))) {
                    rightRotate(arr, n, outOfPlace, index);

                    // the new out-of-place entry is now 2
                    // steps ahead
                    if (index - outOfPlace >= 2) {
                        outOfPlace = outOfPlace + 2;
                    }
                    else {
                        outOfPlace = -1;
                    }
                }
            }

            // if no entry has been flagged out-of-place
            if (outOfPlace == -1)
            {
                // check if current entry is out-of-place
                if (((arr[index] >= 0)
                        && ((index & 0x01) == 0))
                        || ((arr[index] < 0)
                        && (index & 0x01) == 1)) {
                    outOfPlace = index;
                }
            }
        }
    }

    // A utility function to print
    // an array 'arr[]' of size 'n'
    private static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Driver Code
    public static void main(String[] args)
    {
         *//*int arr[] = {-5, 3, 4, 5, -6,
                         -2, 8, 9, -1, -4};
        int arr[] = {-5, -3, -4, -5, -6,
                     2 , 8, 9, 1 , 4};
        int arr[] = {5, 3, 4, 2, 1,
                     -2 , -8, -9, -1 , -4};
        int arr[] = {-5, 3, -4, -7,
                     -1, -2 , -8, -9, 1 , -4};*//*
        int[] arr = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
        int n = arr.length;

        System.out.println("Given array is ");
        printArray(arr, n);

        rearrange(arr, n);

        System.out.println("RearrangeD array is ");
        printArray(arr, n);
    }*/

    // 2. First Efficient Approach
    // Time Complexity of this solution is : O(n(log(n)))
    // Auxiliary Space Complexity of this solution is : O(1)

    private static void fill1(int[] a, int neg, int pos) {
        if (neg % 2 == 1) {
            for (int i = 1; i < neg; i += 2) {
                int c = a[i];
                int d = a[i + neg];
                a[i] = d;
                a[i + neg] = c;
            }
        }
        else {
            for (int i = 1; i <= neg; i += 2) {
                int c = a[i];
                int d = a[i + neg - 1];
                a[i] = d;
                a[i + neg - 1] = c;
            }
        }
    }

    // Function which works in the condition when number of
    // negative numbers are greater than positive numbers
    private static void fill2(int a[], int neg, int pos)
    {
        if (pos % 2 == 1) {
            for (int i = 1; i < pos; i += 2) {
                int c = a[i];
                int d = a[i + pos];
                a[i] = d;
                a[i + pos] = c;
            }
        }
        else {
            for (int i = 1; i <= pos; i += 2) {
                int c = a[i];
                int d = a[i + pos - 1];
                a[i] = d;
                a[i + pos - 1] = c;
            }
        }
    }

    // Reverse the array
    private static void reverse(int[] a, int n)
    {
        int i, k, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }

    // Print the array
    static void print(int[] a, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    // Driver Code
    public static void main(String[] args)
            throws java.lang.Exception
    {
        // Given array
        int[] arr = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
        int n = arr.length;
        System.out.println("Given array is  ");
        print(arr, n);
        int neg = 0, pos = 0;
        for (int j : arr) {
            if (j < 0) {
                neg++;
            }
            else {
                pos++;
            }
        }
        // Sort the array
        Arrays.sort(arr);

        if (neg <= pos) {
            fill1(arr, neg, pos);
        }
        else {
            // reverse the array in this condition
            reverse(arr, n);
            fill2(arr, neg, pos);
        }
        System.out.println("Rearranged array is  ");
        print(arr, n);
    }

    // 2. Second Efficient Approach
    // Time Complexity of this solution is : O(n)
    // Auxiliary Space Complexity of this solution is : O(1)

    /*private static void rearrange(int[] arr, int n)
    {
        int i = 0, j = n - 1;

        // shift all negative values to the end
        while (i < j) {
            while (i <= n - 1 && arr[i] > 0)
                i += 1;
            while (j >= 0 && arr[j] < 0)
                j -= 1;
            if (i < j)
                swap(arr, i, j);
        }

        // i has index of leftmost negative element
        if (i == 0 || i == n)
            return;

        // start with first positive
        // element at index 0

        // Rearrange array in alternating positive &
        // negative items
        int k = 0;
        while (k < n && i < n) {
            // swap next positive element
            // at even position
            // from next negative element.
            swap(arr, k, i);
            i = i + 1;
            k = k + 2;
        }
    }

    // Utility function to print an array
    private static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    static void swap(int[] arr, int index1, int index2)
    {
        int c = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = c;
    }

    // Driver code
    public static void main(String[] args)
    {
        int[] arr = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };

        int n = arr.length;

        System.out.println("Given array is ");
        printArray(arr, n);

        rearrange(arr, n);

        System.out.println("Rearranged array is ");
        printArray(arr, n);
    }*/
}
