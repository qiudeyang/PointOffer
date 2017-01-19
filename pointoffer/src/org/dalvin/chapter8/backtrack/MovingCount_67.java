package org.dalvin.chapter8.backtrack;

/**
 * Created by qiudeyang on 19/01/17.
 */
public class MovingCount_67 {
    public static int movingCount(int target, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        int count = movingCountCore(target, rows, cols, 0, 0, visited);
        return count;
    }

    public static int movingCountCore(int target, int rows, int cols, int row, int col, boolean[][] visited) {
        int count = 0;
        if (hasCheck(target, rows, cols, row, col, visited)) {
            visited[row][col] = true;
            count = 1 + movingCountCore(target, rows, cols, row - 1, col, visited)
                    + movingCountCore(target, rows, cols, row + 1, col, visited)
                    + movingCountCore(target, rows, cols, row, col - 1, visited)
                    + movingCountCore(target, rows, cols, row, col + 1, visited);
        }
        return count;
    }

    public static boolean hasCheck(int target, int rows, int cols, int row, int col, boolean[][] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col] && getNumber(row) + getNumber(col) <= target) {
            return true;
        }
        return false;
    }

    public static int getNumber(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[6][5];
        System.out.println(movingCount(10, matrix.length, matrix[0].length));
    }
}
