package com.LeetCode;

import java.util.Scanner;
import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] height = new int[length];
        for (int i = 0; i < length; i++) {
            height[i] = scanner.nextInt();
        }*/
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = trap(height);
        System.out.println(result);
    }
    private static int trap(int[] height) {
        int length = height.length;
        int left = 0;
        int right = length - 1;
        int finalResult = 0;
        int maximumLeft = 0;
        int maximumRight = 0;
//        Stack<Integer> integerStack = new Stack<>();
//        integerStack.pop()
        while (left <= right) {
            if (height[left] <= height[right]){
                if (height[left] >= maximumLeft) {
                    maximumLeft = height[left];
                }
                else {
                    finalResult += maximumLeft - height[left];
                }
                left++;
            }
            else {
                if (height[right] >= maximumRight) {
                    maximumRight = height[right];
                }
                else {
                    finalResult += maximumRight - height[right];
                }
                right--;
            }
        }
        return finalResult;

    }
}
