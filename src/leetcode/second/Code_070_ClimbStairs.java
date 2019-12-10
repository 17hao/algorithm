package leetcode.second;

/**
 * 爬楼梯
 * base case: dp[0] = 0; dp[1] = 1; dp[2] = 2;
 * 状态转移方程:dp[i] = dp[i - 1] + dp[i - 2]
 *
 * @since 11-23 Saturday
 */
public class Code_070_ClimbStairs {
    static int climbStairs(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(0));
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(7));
    }
}
