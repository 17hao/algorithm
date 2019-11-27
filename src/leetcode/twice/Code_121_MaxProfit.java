package leetcode.twice;

/**
 * 给定一个数组,找出最大收益
 * base case: dp[0][0] = 0; dp[0][1] = -prices[0]
 * 状态转移方程:
 * dp[i][0] = Max(dp[i - 1][0], dp[i - 1][1] + prices[i])
 * dp[i][1] = Max(dp[i - 1][1], dp[i - 1][0] - prices[i])
 *
 * @since 11-27 Wednesday
 */
public class Code_121_MaxProfit {
    static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }

    static int maxProfitV2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    static int maxProfitV3(int[] prices) {
        if (prices.length == 0) return 0;
        int dp_i_0 = 0, dp_i_1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_0 - prices[i], dp_i_1);
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        int[] p1 = {};
        int[] p2 = {7, 1, 2, 3, 4, 5, 6};
        int[] p3 = {1, 2, 3, 4, 5};
        int[] p4 = {4, 3, 2, 1};
        // System.out.println(maxProfit(p1));
        // System.out.println(maxProfit(p2));
        // System.out.println(maxProfit(p3));
        // System.out.println(maxProfit(p4));

        System.out.println(maxProfitV2(p1));
        System.out.println(maxProfitV2(p2));
        System.out.println(maxProfitV2(p3));
        System.out.println(maxProfitV2(p4));
    }
}
