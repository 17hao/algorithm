package leetcode.fourth;

/**
 * 股票买卖的最佳时机
 * 最多只允许完成一笔交易（即买入和卖出一支股票一次）
 * 状态转移方程:
 *     dp[m][0] = max(dp[m - 1][0], dp[m - 1][1] + prices[m])
 *     dp[m][1] = max(dp[m - 1][1], - prices[m])
 *  base case(基准状态)dp[0][0] = 0, dp[0][1] = -prices[0]
 *
 * @since 2020-3-23 Monday 21:51
 */
public class Code_121_MaxProfit {
    static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
        }
        return dp[len - 1][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
