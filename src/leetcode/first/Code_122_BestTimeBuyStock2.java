package leetcode.first;

/**
 * 股票买卖2, 可以无限次交易,求最大利润.
 * 状态转移方程: i天数, k交易次数, 0/1是否持有.
 * dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k + 1][1] + prices[i])
 * dp[i][k][1] = max(dp[i - 1][k + 1][0] - price[i], dp[i - 1][k][1])
 * base case: dp[0][0] = 0 dp[0][1] = -Integer.MIN_VALUE;
 *
 * @since 2019-12-17 Tuesday
 */
public class Code_122_BestTimeBuyStock2 {
    static int maxProfit(int[] prices) {
        int dp_i_0 = 0, dp_i_1 = -prices[0];
        for (int price : prices) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_0 - price, dp_i_1);
        }
        return dp_i_0;
    }

    static int maxProfitV2(int[] prices) {
        int[][] dp = new int[prices.length][prices.length];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            }
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 9, 3, 6, 5}));
        System.out.println(maxProfitV2(new int[]{7, 1, 9, 3, 6, 5}));
        System.out.println(maxProfitV2(new int[]{7, 1, 2, 3, 6, 5}));
    }
}
