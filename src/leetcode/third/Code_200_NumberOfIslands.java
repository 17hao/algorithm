package leetcode.third;

/**
 * 岛屿数量
 * 
 * @since 2020-7-31 17:03 - 17:17
 */
public class Code_200_NumberOfIslands {
    int numIslands(int[][] grid) {
        if (grid.length == 0)
            return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    helper(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void helper(int[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 2;
        helper(grid, i - 1, j);
        helper(grid, i, j - 1);
        helper(grid, i + 1, j);
        helper(grid, i, j + 1);
    }

    public static void main(String[] args) {
        Code_200_NumberOfIslands c = new Code_200_NumberOfIslands();
        // System.out.println(c.numIslands(new char[][] { { '1', '1', '0', '0', '0' }, {
        // '1', '1', '0', '0', '0' },
        // { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } }));
        System.out.println(c.numIslands(new int[][] {{0, 0, 0, 1, 0, 0, 0, 1, 1, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 1}, {0, 0, 1, 1, 0, 1, 0, 0, 0, 1}, {1, 0, 1, 1, 0, 1, 1, 1, 0, 1}, {0, 0, 0, 1, 1, 1, 0, 0, 0, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1}, {1, 1, 0, 1, 1, 1, 0, 1, 0, 1}, {0, 0, 1, 1, 0, 1, 0, 0, 1, 1}, {0, 1, 1, 0, 1, 0, 0, 0, 1, 1}}));
    }
}