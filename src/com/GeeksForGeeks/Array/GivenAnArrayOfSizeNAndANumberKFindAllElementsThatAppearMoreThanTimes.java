package com.GeeksForGeeks.Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class GivenAnArrayOfSizeNAndANumberKFindAllElementsThatAppearMoreThanTimes {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();*/
        int[] arr = {3, 1, 2, 2, 1, 2, 3, 3};
        int n = arr.length;
        int k = 4;
        printElements(arr, n, k);
    }

    // 1. Using HashMap
    // TimeComplexity of this solution is : O(n)
    // Auxiliary Space Complexity of this solution is : O(n)

    /*private static void moreThanNdK(int[] arr, int n, int k) {
        int x = n / k;
        // Hash map initialization
        HashMap<Integer, Integer> map = new HashMap<>();
        // count the frequency of each element.
        for (int i = 0; i < n; i++) {
            // is element doesn't exist in hash table
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            }
            // if element does exist in the hash table
            else {
                int count = map.get(arr[i]);
                map.put(arr[i], count + 1);
            }
        }
        // iterate over each element in the hash table
        // and check their frequency, if it is more than
        // n/k, print it.
        for (Map.Entry mp : map.entrySet()) {
            Integer temp = (Integer)mp.getValue();
            if (temp > x) {
                System.out.print(mp.getKey() + " ");
            }
        }
        System.out.println();
    }*/

    // 2. Using Loop

    /*static class eleCount {
        int e; // Element
        int c; // Count
    };

    // Prints elements with more
// than n/k occurrences in arr[]
// of size n. If there are no
// such elements, then it prints
// nothing.
    private static void moreThanNdK(int[] arr, int n, int k)
    {
        // k must be greater than
        // 1 to get some output
        if (k < 2)
            return;

    *//* Step 1: Create a temporary
       array (contains element
       and count) of size k-1.
       Initialize count of all
       elements as 0 *//*
        eleCount []temp = new eleCount[k - 1];
        for (int i = 0; i < k - 1; i++) {
            temp[i] = new eleCount();
        }
        for (int i = 0; i < k - 1; i++) {
            temp[i].c = 0;
        }

    *//* Step 2: Process all
      elements of input array *//*
        for (int i = 0; i < n; i++) {
            int j;

        *//* If arr[i] is already present in
           the element count array,
           then increment its count
         *//*
            for (j = 0; j < k - 1; j++) {
                if (temp[j].e == arr[i]) {
                    temp[j].c += 1;
                    break;
                }
            }
            *//* If arr[i] is not present in temp[] *//*
            if (j == k - 1) {
                int l;
            *//* If there is position available
              in temp[], then place arr[i] in
              the first available position and
              set count as 1*//*
                for (l = 0; l < k - 1; l++) {
                    if (temp[l].c == 0) {
                        temp[l].e = arr[i];
                        temp[l].c = 1;
                        break;
                    }
                }
            *//* If all the position in the
               temp[] are filled, then decrease
               count of every element by 1 *//*
                if (l == k - 1) {
                    for (l = 0; l < k - 1; l++) {
                        temp[l].c -= 1;
                    }
                }
            }
        }
        *//*Step 3: Check actual counts of
         * potential candidates in temp[]*//*
        for (int i = 0; i < k - 1; i++) {
            // Calculate actual count of elements
            int ac = 0; // actual count
            for (int j = 0; j < n; j++) {
                if (arr[j] == temp[i].e) {
                    ac++;
                }
            }
            // If actual count is more than n/k,
            // then print it
            if (ac > n / k) {
                System.out.print(temp[i].e + " ");
            }
        }
        System.out.println();
    }*/

    // 3. Using TreeMap
    // TimeComplexity of this solution is : O(n)
    // Auxiliary Space Complexity of this solution is : O(n)

    private static void printElements(int[] arr, int n, int k) {
        // Calculating n/k
        int x = n / k;
        // Counting frequency of every
        // element using Counter
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }
        // Traverse the map and print all
        // the elements with occurrence
        // more than n/k times
        for (Map.Entry m:mp.entrySet()) {
            if ((int)m.getValue() > x) {
                System.out.print(m.getKey() + " ");
            }
        }
        System.out.println();
    }
}
