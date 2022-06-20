package com.LeetCode;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] answer = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(answer));
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] answer = new int[length];
        Stack<Integer> myStack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!myStack.isEmpty() && temperatures[myStack.peek()] < temperatures[i]) {
                answer[myStack.peek()] = i - myStack.peek();
                myStack.pop();
            }
            myStack.push(i);
        }
        return answer;
    }
}
