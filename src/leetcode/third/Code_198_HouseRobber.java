package leetcode.third;

/**
 * 打家劫舍
 * 状态转移方程: dp[0][n] = dp[1][n - 1]  dp[1][n] = max(dp[0][n - 1] + nums[n], dp[1][n - 1])
 * base case: dp[0][0] = 0  dp[0][1] = nums[0]
 *
 * @since 2020-4-20 Monday 20:55 - 21:16
 */
public class Code_198_HouseRobber {
    static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[][] dp = new int[2][len];
        dp[0][0] = 0;
        dp[1][0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[0][i] = dp[1][i - 1];
            dp[1][i] = Math.max(dp[0][i - 1] + nums[i], dp[1][i - 1]);
        }
        return len == 1 ? dp[1][0] : Math.max(dp[1][len - 1], dp[1][len - 2]);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1}));
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }
}
