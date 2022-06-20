package com.LeetCode;

import java.util.ArrayList;

public class BestMeetingPoint {
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
        int totalDistance = minTotalDistance(grid);
        System.out.println(totalDistance);
    }

    private static int minTotalDistance(int[][] grid) {
        ArrayList<Integer> xCoordinate = new ArrayList<>();
        ArrayList<Integer> yCoordinate = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == 1) {
                    xCoordinate.add(row);
                }
            }
        }

        for (int column = 0; column < grid[0].length; column++) {
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][column] == 1) {
                    yCoordinate.add(column);
                }
            }
        }
        int xCoordinateValue = xCoordinate.get(xCoordinate.size() / 2);
        int yCoordinateValue = yCoordinate.get(yCoordinate.size() / 2);
        int totalDistance = 0;
        for (int xValue : xCoordinate) {
            totalDistance += Math.abs(xCoordinateValue - xValue);
        }
        for (int yValue : yCoordinate) {
            totalDistance += Math.abs(yCoordinateValue - yValue);
        }
        return totalDistance;
    }
}
