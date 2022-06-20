package com.GeeksForGeeks.Array;

import java.util.ArrayList;

public class CommonElements {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int[] A = new int[n1];
        for (int i = 0; i < n1; i++) {
            A[i] = scanner.nextInt();
        }
        int n2 = scanner.nextInt();
        int[] B = new int[n2];
        for (int i = 0; i < n2; i++) {
            B[i] = scanner.nextInt();
        }
        int n3 = scanner.nextInt();
        int[] C = new int[n3];
        for (int i = 0; i < n1; i++) {
            C[i] = scanner.nextInt();
        }
        */
        int[] A = {1, 5, 10, 20, 40, 80};
        int[] B = {6, 7, 20, 80, 100};
        int[] C = {3, 4, 15, 20, 30, 70, 80, 120};
        int n1 = A.length;
        int n2 = B.length;
        int n3 = C.length;
        ArrayList<Integer> ans = commonElements(A, B, C, n1, n2, n3);
        for(Integer element : ans) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private static ArrayList<Integer> commonElements(int[] A, int[] B, int[] C, int n1, int n2, int n3) {
        int i = 0;
        int j = 0;
        int k = 0;
        int prev = Integer.MIN_VALUE;
        ArrayList<Integer> result = new ArrayList<>();
        while (i < n1 && j < n2 && k < n3) {
            int min = Math.min(Math.min(A[i], B[j]), C[k]);
            if (A[i] == B[j] && B[j] == C[k]) {
                if (A[i] > prev) {
                    result.add(A[i]);
                    prev = A[i];
                }
                ++i;
                ++j;
                ++k;
            }
            else if (A[i] == min) {
                ++i;
            }
            else if (B[j] == min) {
                ++j;
            }
            else {
                ++k;
            }
        }
        return result;
    }
}
