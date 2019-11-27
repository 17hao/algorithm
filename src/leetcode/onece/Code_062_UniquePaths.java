package leetcode.onece;

/**
 * m x n的方格,从左上到右下,每次走一格.最多几种走法
 * base case: dp[0][0] = 1; dp[0][n] = n; dp[m][0] = m;
 * 状态转移方程: dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
 *
 * @since 11-27 Wednesday
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
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(7 ,3));
    }
}
