package com.LeetCode;

import java.util.*;

public class StrangePrinterII {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] targetGrid = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                targetGrid[i][j] = scanner.nextInt();
            }
        }
        */
        int[][] targetGrid = {{1, 1, 1, 1}, {1, 2, 2, 1}, {1, 2, 2, 1}, {1, 1, 1, 1}};
        boolean ans = isPrintable(targetGrid);
        System.out.println(ans);
    }
    private static boolean isPrintable(int[][] targetGrid) {
        Map<Integer, int[]> boundsMap = new HashMap<>();
        int rows = targetGrid.length, columns = targetGrid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int color = targetGrid[i][j];
                if (!boundsMap.containsKey(color))
                    boundsMap.put(color, new int[]{i, i, j, j});
                else {
                    int[] bounds = boundsMap.get(color);
                    bounds[0] = Math.min(bounds[0], i);
                    bounds[1] = Math.max(bounds[1], i);
                    bounds[2] = Math.min(bounds[2], j);
                    bounds[3] = Math.max(bounds[3], j);
                    boundsMap.put(color, bounds);
                }
            }
        }
        Set<Integer> keySet = boundsMap.keySet();
        Map<Integer, List<Integer>> greaterMap = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int color = targetGrid[i][j];
                List<Integer> list = greaterMap.getOrDefault(color, new ArrayList<>());
                for (int key : keySet) {
                    if (key != color) {
                        int[] bounds = boundsMap.get(key);
                        if (i >= bounds[0] && i <= bounds[1] && j >= bounds[2] && j <= bounds[3])
                            list.add(key);
                    }
                }
                greaterMap.put(color, list);
            }
        }
        Map<Integer, Integer> inDegreeMap = new HashMap<>();
        for (int color : keySet) {
            List<Integer> nextColors = greaterMap.getOrDefault(color, new ArrayList<>());
            for (int nextColor : nextColors) {
                int inDegree = inDegreeMap.getOrDefault(nextColor, 0) + 1;
                inDegreeMap.put(nextColor, inDegree);
            }
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int color : keySet) {
            int inDegree = inDegreeMap.getOrDefault(color, 0);
            if (inDegree == 0) {
                visited.add(color);
                queue.offer(color);
            }
        }
        while (!queue.isEmpty()) {
            int color = queue.poll();
            List<Integer> nextColors = greaterMap.getOrDefault(color, new ArrayList<>());
            for (int nextColor : nextColors) {
                int inDegree = inDegreeMap.getOrDefault(nextColor, 0) - 1;
                if (inDegree == 0) {
                    inDegreeMap.remove(nextColor);
                    visited.add(nextColor);
                    queue.offer(nextColor);
                } else
                    inDegreeMap.put(nextColor, inDegree);
            }
        }
        return visited.size() == keySet.size();
    }
}
