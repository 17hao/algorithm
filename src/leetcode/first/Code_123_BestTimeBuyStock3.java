package leetcode.first;

/**
 * 股票买卖2, 最多交易2次,求最大利润.
 *
 * @since 2019-12-17 Tuesday
 */
public class Code_123_BestTimeBuyStock3 {
    static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int len = prices.length;
        int[][][] dp = new int[len][3][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= 2; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j - 1][0] - prices[i], dp[i - 1][j][1]);
            }
        }
        return dp[len - 1][2][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit(new int[]{7, 5, 3, 1, 0}));
    }
}
