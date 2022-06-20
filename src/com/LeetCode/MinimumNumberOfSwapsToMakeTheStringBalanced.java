package com.LeetCode;

import java.util.Stack;

public class MinimumNumberOfSwapsToMakeTheStringBalanced {
    public static void main(String[] args) {
        String s = "][][";
        int answer = minSwaps(s);
        System.out.println(answer);
    }

    // 1. First Approach
    // Time Complexity of this is : O(n)
    // Auxiliary Space Complexity of this is : O(1)

    private static int minSwaps(String s) {
         int openCount = 0;
         int minimumSwap = 0;

         for (char c : s.toCharArray()) {
             if (c == '[') {
                 openCount++;
             }
             else {
                 if (openCount == 0) {
                     minimumSwap++;
                     openCount++;
                 }
                 else {
                     openCount--;
                 }
             }
         }
         return minimumSwap;
     }

     // 2. Second Approach Using Stack
     // Time Complexity of this is : O(n)
     // Auxiliary Space Complexity of this is : O(n)

    /*private static int minSwaps(String s) {
        Stack<Character> charStack = new Stack<>();
        int totalCount = 0;
        for (Character ch : s.toCharArray()) {
            if (ch == '[') {
                charStack.push(ch);
            }
            else {
                if (!charStack.isEmpty() && ch == ']') {
                    charStack.pop();
                }
                else {
                    totalCount++;
                }
            }
        }
        return (totalCount + 1) / 2;
    }*/
}
