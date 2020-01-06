package leetcode.first;

/**
 * 给定正整数 n，
 * 找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 状态转移方程: dp[i]是i的完全平方数之和的个数
 * dp[i] = min(dp[i - j * j]) + 1
 * base case: dp[i] = i
 *
 * @since 2020-1-6 Monday 21:21
 */
public class Code_279_PerfectSquares {
    static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }
}
