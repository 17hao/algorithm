package leetcode.sixth;

import java.util.Arrays;

/**
 * 零钱兑换
 * 
 * @since 2020-7-23 Thursday 15：49 - 15:55
 */
public class Code_322_CoinChange {
    static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                dp[i] = Math.min(i - coin >= 0 ? dp[i - coin] + 1 : amount + 1, dp[i]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[] { 1 }, 1));
        System.out.println(coinChange(new int[] { 1 }, 0));
        System.out.println(coinChange(new int[] { 2 }, 3));
        System.out.println(coinChange(new int[] { 1, 2, 3 }, 11));
        System.out.println(coinChange(new int[] { 1, 5, 3 }, 11));
        System.out.println(coinChange(new int[] { 2, 4, 5, 1, 123141 }, 1512342));
    }
}