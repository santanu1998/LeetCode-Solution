package com.GeeksForGeeks.Array;

public class ThreeWayPartitioning {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int a = 1;
        int b = 2;
        threeWayPartition(array, a, b);
        printArray(array);
    }
    private static void threeWayPartition(int[] array, int a, int b)
    {
        // code here

        /*int k = 0;
        int N = array.length;
        //  grab one by one all elements less than a and exchange it with array[k++]
        for (int i = 0; i < N; i++) {
            if (array[i] < a) {
                exch(array, k++, i);

            }
        }
        //  grab one by one all elements greater than equal to a and less than equal to b;       exchange it with array[k++] element
        for (int i = 0; i < N; i++) {
            if (array[i] >= a && array[i] <= b) {
                exch(array, k++, i);

            }
        }
        // grab one by one all elements greater than b;  exchange it with array[k++] element
        for (int i = 0; i < array.length; i++) {
            if (array[i] > b) {
                exch(array, k, i);
                if (k != array.length - 1) {
                    k++;
                }

            }
        }*/

        int low = 0;
        int high = array.length - 1;
        int i;
        for (i = 0; i <= high; i++) {
            if (array[i] < a) {
                swap(array, low, i);
                low++;
            }
            else if (array[i] > b) {
                swap(array, high, i);
                high--;
                i--;
            }
        }

    }
    private static void swap(int[] a, int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static void printArray(int[] array) {
        for (int arr : array) {
            System.out.print(arr + " ");
        }
        System.out.println();
    }
}
