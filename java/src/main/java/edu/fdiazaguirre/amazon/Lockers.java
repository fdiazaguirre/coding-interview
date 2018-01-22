package edu.fdiazaguirre.amazon;

import java.util.List;

import com.google.common.annotations.VisibleForTesting;

public class Lockers {

	public static int[][] getLockerDistanceGrid(int cityLength, int cityWidth, List<Point> lockerPositions) {
        int[][] grid = new int[cityLength][cityWidth];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = findClosestManhattanDistance(getCoordinate(row), getCoordinate(col), lockerPositions);
            }
        }
        return grid;
    }

    private static int getCoordinate(int zeroBasedPosition) {
        return zeroBasedPosition + 1;
    }

    @VisibleForTesting
    static int findClosestManhattanDistance(int x, int y, List<Point> lockerPositions) {
        int closesDistance = Integer.MAX_VALUE;
        for (Point p : lockerPositions) {
            int distance = Math.abs(x - p.x) + Math.abs(y - p.y);
            closesDistance = Math.min(distance, closesDistance);
            // we know we can't get better than 0 distance
            if (closesDistance == 0)
                return closesDistance;
        }
        return closesDistance;
    }

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
