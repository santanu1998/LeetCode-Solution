package com.LeetCode;

public class ContainerWithMostWater {
    public static void main(String[] args) {
//        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height = {1, 1};
        int maximumArea = maxArea(height);
        System.out.println(maximumArea);
    }
    private static int maxArea(int[] height) {
        int first = 0;
        int last = height.length - 1;
        int maximumArea = 0;
        while(first < last) {
            int minimumHeight = Math.min(height[first], height[last]);
            maximumArea = Math.max(maximumArea, (minimumHeight * (last - first)));
            if (height[first] < height[last]) {
                ++first;
            }
            else {
                --last;
            }
        }
        return maximumArea;
    }
}
