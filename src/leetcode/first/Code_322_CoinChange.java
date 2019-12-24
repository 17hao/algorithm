package leetcode.first;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 状态转移方程: dp[i] = 1 + min(dp[i - coin] | coin in coins])
 * base case: dp[0] = 0
 *
 * @since 2019-12-24 Tuesday
 */
public class Code_322_CoinChange {
    static int coinChangeV1(int[] coins, int amount) {
        if (amount == 0) return 0;
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin > amount) continue;
            int subPro = coinChangeV1(coins, amount - coin);
            if (subPro == -1) continue;
            result = Math.min(result, subPro + 1);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    int coinChangeV2(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        return helper(coins, amount, memo);
    }

    private int helper(int[] coins, int amount, int[] memo) {
        if (amount == 0) return 0;
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount < coin) continue;
            int subPro = helper(coins, amount - coin, memo);
            if (subPro == -1) continue;
            result = Math.min(result, subPro + 1);
        }
        memo[amount] = result == Integer.MAX_VALUE ? -1 : result;
        return memo[amount];
    }

    static int coinChangeV3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(1 + dp[i - coin], dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChangeV1(new int[]{1, 2, 5}, 11));
        System.out.println(coinChangeV1(new int[]{1, 2, 5}, 5));
        System.out.println(coinChangeV1(new int[]{1, 2, 5}, 3));
        System.out.println(coinChangeV1(new int[]{4, 9, 5}, 3));
        System.out.println("===");
        System.out.println(new Code_322_CoinChange().coinChangeV2(new int[]{1, 2, 5}, 11));
        System.out.println(new Code_322_CoinChange().coinChangeV2(new int[]{1, 2, 5}, 5));
        System.out.println(new Code_322_CoinChange().coinChangeV2(new int[]{1, 2, 5}, 3));
        System.out.println(new Code_322_CoinChange().coinChangeV2(new int[]{4, 9, 5}, 3));
        System.out.println("===");
        System.out.println(coinChangeV3(new int[]{1, 2, 5}, 11));
        System.out.println(coinChangeV3(new int[]{1, 2, 5}, 5));
        System.out.println(coinChangeV3(new int[]{1, 2, 5}, 3));
        System.out.println(coinChangeV3(new int[]{4, 9, 5}, 3));
    }
}
