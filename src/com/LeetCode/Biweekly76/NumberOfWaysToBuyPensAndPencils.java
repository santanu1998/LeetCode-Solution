package com.LeetCode.Biweekly76;

import java.util.Scanner;

public class NumberOfWaysToBuyPensAndPencils {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*int total = scanner.nextInt();
        int cost1 = scanner.nextInt();
        int cost2 = scanner.nextInt();*/
        int total = 20;
        int cost1 = 10;
        int cost2 = 5;
        long ans = waysToBuyPensPencils(total, cost1, cost2);
        System.out.println(ans);
    }
    private static long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (total < cost1 && total < cost2) {
            return 1;
        }

        long  ways = 0;
        int i, a;
        a = cost1 / cost2;
        for(i = 0; i <= a; ++i){
            int totals;
            totals = a - (i * cost2);
            ways += (totals / total) + 1;
        }
        return ways;


    }
}
