package leetcode.first;

/**
 * 最小路径和
 * 状态转移方程: grid[i][j] = min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j]
 * base case: grid[i][j]
 *
 * @since 2020-1-3
 */
public class Code_064_MinPathSum {
    static int minPathSumV1(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] res = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0) {
                    res[i][j] = grid[i][j];
                } else if (i == 0) {
                    res[i][j] = res[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    res[i][j] = res[i - 1][j] + grid[i][j];
                } else {
                    res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
                }
            }
        }
        return res[row - 1][column - 1];
    }

    static int minPathSumV2(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(minPathSumV1(m));
        System.out.println(minPathSumV2(m));
    }
}
