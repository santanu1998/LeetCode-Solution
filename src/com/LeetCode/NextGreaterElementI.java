package com.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] answer = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(answer));
    }

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreater = nextGreaterRight(nums2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], nextGreater[i]);
        }
        int[] answer = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            answer[i] = map.get(nums1[i]);
        }
        return answer;
    }
    private static int[] nextGreaterRight(int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[nums2.length];
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && stack.peek() < nums2[i]) {
                stack.pop();
            }
            answer[i] = stack.size() > 0 ? stack.peek() : -1;
            stack.push(nums2[i]);
        }
        return answer;
    }
}
