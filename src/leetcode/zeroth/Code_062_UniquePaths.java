package leetcode.zeroth;

/**
 * m x n的方格从左上到右下有几种走法,每次移动一格
 * 状态转移方程: dp[m][n] = dp[m - 1][n] + dp[m][n - 1]
 *
 * @data 11-24 Sunday
 */
public class Code_062_UniquePaths {
    static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(0, 0));
        System.out.println(uniquePaths(7, 3));
    }
}
