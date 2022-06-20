package com.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class T {
    public int i;
    public int j;
    public int h;
    // heightMap[i][j] or the height after filling water

    public T(int i, int j, int h) {
        this.i = i;
        this.j = j;
        this.h = h;
    }
}

public class TrappingRainWaterII {
    public static void main(String[] args) {
        int[][] heightMap = {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
        int result = trapRainWater(heightMap);
        System.out.println(result);
    }

    /*public static class Pair implements Comparable<Pair> {
        int x;
        int y;
        int height;

        Pair(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }

        public int compareTo(Pair o) {
            return this.height - o.height;
        }
    }

    private static int trapRainWater(int[][] heightMap) {
        int row = heightMap.length;
        int column = heightMap[0].length;
        boolean[][] visited = new boolean[row][column];
        PriorityQueue<Pair> pairPriorityQueue = new PriorityQueue<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 || j == 0 || i == row - 1 || j == column - 1) {
                    pairPriorityQueue.add(new Pair(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }
        int[][] calls = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int result = 0;

        while (pairPriorityQueue.size() > 0) {
            Pair rem = pairPriorityQueue.remove();
            for (int[] call : calls) {
                int newI = rem.x + call[0];
                int newJ = rem.y + call[1];

                if (newI >= 0 && newJ >= 0 && newI < row && newJ < column && !visited[newI][newJ]) {
                    if (heightMap[newI][newJ] < rem.height)
                        result += rem.height - heightMap[newI][newJ];
                    visited[newI][newJ] = true;
                    pairPriorityQueue.add(new Pair(newI, newJ, Math.max(heightMap[newI][newJ], rem.height)));
                }
            }
        }

        return result;
    }*/
    private static int trapRainWater(int[][] heightMap) {
        final int m = heightMap.length;
        final int n = heightMap[0].length;
        final int[] dirs = {0, 1, 0, -1, 0};
        int ans = 0;
        Queue<T> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.h));
        boolean[][] seen = new boolean[m][n];

        for (int i = 0; i < m; ++i) {
            minHeap.offer(new T(i, 0, heightMap[i][0]));
            minHeap.offer(new T(i, n - 1, heightMap[i][n - 1]));
            seen[i][0] = true;
            seen[i][n - 1] = true;
        }

        for (int j = 1; j < n - 1; ++j) {
            minHeap.offer(new T(0, j, heightMap[0][j]));
            minHeap.offer(new T(m - 1, j, heightMap[m - 1][j]));
            seen[0][j] = true;
            seen[m - 1][j] = true;
        }

        while (!minHeap.isEmpty()) {
            final int i = minHeap.peek().i;
            final int j = minHeap.peek().j;
            final int h = minHeap.poll().h;
            for (int k = 0; k < 4; ++k) {
                final int x = i + dirs[k];
                final int y = j + dirs[k + 1];
                if (x < 0 || x == m || y < 0 || y == n)
                    continue;
                if (seen[x][y])
                    continue;
                if (heightMap[x][y] < h) {
                    ans += h - heightMap[x][y];
                    minHeap.offer(new T(x, y, h)); // fill the water on grid[x][y]
                } else {
                    minHeap.offer(new T(x, y, heightMap[x][y]));
                }
                seen[x][y] = true;
            }
        }

        return ans;
    }
}
