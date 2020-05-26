package leetcode.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 三角形的最小路径和
 *
 * @since 2020-5-25 Tuesday 9:37
 */
public class Code_120_Triangle {
    int _minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        if (row == 0) return 0;
        return _dfs(0, 0, triangle, row);
    }

    private int _dfs(int level, int i, List<List<Integer>> triangle, int row) {
        if (level == row - 1) {
            return triangle.get(level).get(i);
        }
        int left = _dfs(level + 1, i, triangle, row);
        int right = _dfs(level + 1, i + 1, triangle, row);
        return Math.min(left, right) + triangle.get(level).get(i);
    }

    int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        if (row == 0) return 0;
        Integer[][] mem = new Integer[row][row];
        return dfs(0, 0, triangle, mem, row);
    }

    private int dfs(int level, int i, List<List<Integer>> triangle, Integer[][] mem, int row) {
        if (mem[level][i] != null) {
            return mem[level][i];
        }
        if (level == row - 1) {
            return triangle.get(level).get(i);
        }
        int left = dfs(level + 1, i, triangle, mem, row);
        int right = dfs(level + 1, i + 1, triangle, mem, row);
        return mem[level][i] = Math.min(left, right) + triangle.get(level).get(i);
    }

    /**
     * 状态方程定义: dp[i]每一行第i个数字的最小路径
     * 状态转移方程 dp[i] = min(dp[i], dp[i - 1]) + triangle(i) 自底向上
     */
    int minimumTotalDP(List<List<Integer>> triangle) {
        int row = triangle.size();
        if (row == 0) return 0;
        int[] dp = new int[row + 1];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Code_120_Triangle c = new Code_120_Triangle();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(c._minimumTotal(triangle));
        System.out.println(c.minimumTotal(triangle));
        System.out.println(c.minimumTotalDP(triangle));
    }
}
