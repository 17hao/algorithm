package leetcode.second;

/**
 * 给定一个数组,找到最大的股票收益
 * base case: dp[0][0] = 0; dp[0][1] = -prices[0]
 * 状态转移方程:
 * dp[i][0] = Max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
 * dp[i][1] = Max(dp[i - 1][1], - prices[i])
 *
 * @since 11-24 Sunday
 */
public class Code_121_MaxProfit {
    static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    static int maxProfitV2(int[] prices) {
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        int[] a = {7, 1, 6, 5, 9, 2};
        int[] b = {7, 1, 6, 5, 4, 2};
        int[] c = {7, 6, 5, 4};
        System.out.println(maxProfitV2(a));
        System.out.println(maxProfitV2(b));
        System.out.println(maxProfitV2(c));
    }
}
