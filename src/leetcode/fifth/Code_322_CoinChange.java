package leetcode.fifth;

import java.util.Arrays;

/**
 * 零钱兑换 
 * 状态方程定义：dp[i]为兑换金额为i所需的最大硬币数量
 * 状态转移方程：dp[i] = if (min(coin) > target) dp[i] = max_int; else min(dp[i - coin])
 * 初始状态：dp[i] = amount + 1,dp[0]=0
 * 结果：dp[i]
 * 
 * @since 2020-7-17 Friday 22:42 - 23:16
 */
public class Code_322_CoinChange {
    static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i < c) continue;
                dp[i] = Math.min(dp[i], dp[i - c] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[] { 1, 2, 5 }, 0));
        System.out.println(coinChange(new int[] { 1, 2, 5 }, 11));
        System.out.println(coinChange(new int[] { 2, 5 }, 10));
        System.out.println(coinChange(new int[] { 3 }, 10));
    }
}