package com.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class RepeatAndMissingNumberArray {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(1);
        A.add(2);
        A.add(5);
        A.add(3);
        ArrayList<Integer> result = repeatedNumber(A);
        System.out.println(result);
    }
    private static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        long actualSum = 0;
        long givenSum = 0;
        long actualSquare = 0;
        long givenSquare = 0;
        long n = (long) A.size();

        actualSum = (n * (n+1)) / 2;
        actualSquare = (n * (n+1) * ((2*n) +1) ) / 6;

        for(int a : A){
            givenSum += (long) a;
            givenSquare += (long) a * (long) a;
        }
        long Y = actualSum - givenSum;
        long X = (actualSquare - givenSquare) / Y;

        long missing = (X + Y) / 2 ;

        long duplicate = X - missing;

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add((int)duplicate);
        ans.add((int)missing);
        return ans;
    }
}
