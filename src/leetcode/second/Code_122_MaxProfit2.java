package leetcode.second;

/**
 * 股票买卖最佳时机2
 * 可以多次买卖股票
 * 状态转移方程:
 *     dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
 *     dp[i][1] = max(dp[i - 1][0] - prices[i], dp[i - 1][1])
 * base case(基准状态): dp[0][0] = 0, dp[0][1] = -prices[0]
 *
 * @since 2020-3-23 Monday 22:09
 */
public class Code_122_MaxProfit2 {
    static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[len - 1][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
