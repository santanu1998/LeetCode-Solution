package com.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SubSetSum {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>(N);
        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            arr.add(input);
        }
        */
        int N = 2;
        ArrayList<Integer> arr = new ArrayList<>(N);
        arr.add(2);
        arr.add(3);
        ArrayList<Integer> result = subsetSum(arr, N);
        System.out.println(result);
    }

    private static ArrayList<Integer> subsetSum(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> result = new ArrayList<>();
        myOwnFunction(0, 0, arr, N, result);
        Collections.sort(result);
        return result;
    }

    private static void myOwnFunction(int index, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> sumSubset) {
        if (index == N) {
            sumSubset.add(sum);
            return;
        }
        // For Picking Up the Elements
        myOwnFunction(index + 1, sum + arr.get(index), arr, N, sumSubset);
        // For Non Picking the Elements
        myOwnFunction(index + 1, sum, arr, N, sumSubset);
    }
}
