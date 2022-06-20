package com.LeetCode;

import java.util.Arrays;

public class MinimumInitialEnergyToFinishTasks {
    public static void main(String[] args) {
        int[][] tasks = {{1, 2}, {2, 4}, {4, 8}};
        int answer = minimumEffort(tasks);
        System.out.println(answer);
    }

    private static int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> {
            return (b[1] - b[0]) - (a[1] - a[0]);
        });
        int totalEffort = 0;
        for (int[] task : tasks) {
            totalEffort += task[0];
        }
        int result = totalEffort;
        for (int[] task : tasks) {
            if (task[1] > totalEffort) {
                totalEffort += task[1] - totalEffort;
            }
            totalEffort -= task[0];
        }
        return (result + totalEffort);
    }
}
