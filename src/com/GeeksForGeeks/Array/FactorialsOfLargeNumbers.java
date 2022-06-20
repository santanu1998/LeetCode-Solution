package com.GeeksForGeeks.Array;

import java.util.ArrayList;
import java.util.Scanner;

public class FactorialsOfLargeNumbers {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();*/
        int n = 10;
        ArrayList<Integer> answer = factorial(n);
        for (Integer result : answer) {
            System.out.print(result);
        }
        System.out.println();
    }
    private static ArrayList<Integer> factorial(int n){
        ArrayList<Integer> list = new ArrayList<>();
        java.math.BigInteger num = new java.math.BigInteger("1");
        for (int i = 2; i <= n; i++) {
            num = num.multiply(java.math.BigInteger.valueOf(i));
        }
        char[] charArray = num.toString().toCharArray();
        for (char ch : charArray) {
            int i = Integer.parseInt(String.valueOf(ch));
            list.add(i);
        }
        return list;
    }
}
