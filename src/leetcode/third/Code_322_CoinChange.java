package leetcode.third;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * @since 2020-1-8 9:35
 */
public class Code_322_CoinChange {
    static int coinChangeV1(int[] coins, int amount) {
        if (amount == 0) return 0;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin > amount) continue;
            int subPro = coinChangeV1(coins, amount - coin);
            if (subPro == -1) continue;
            res = Math.min(res, subPro + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    static int coinChangeV2(int[] coins, int amount) {
        int[] temp = new int[amount + 1];
        Arrays.fill(temp, Integer.MIN_VALUE);
        return helper(coins, amount, temp);
    }

    static int helper(int[] coins, int amount, int[] temp) {
        if (amount == 0) return 0;
        if (temp[amount] > Integer.MIN_VALUE) return temp[amount];
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin > amount) continue;
            int subPro = helper(coins, amount - coin, temp);
            if (subPro == -1) continue;
            res = Math.min(subPro + 1, res);
        }
        temp[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return temp[amount];
    }

    /**
     * dp[i] = min(dp[i - coin]) coin in coins
     */
    static int coinChangeV3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin > i) {
                    continue;
                }
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChangeV1(new int[]{1, 2, 5}, 11));
        System.out.println(coinChangeV1(new int[]{2, 5}, 3));
        System.out.println(coinChangeV2(new int[]{1, 2, 5}, 11));
        System.out.println(coinChangeV2(new int[]{2, 5}, 3));
        System.out.println(coinChangeV3(new int[]{1, 2, 5}, 11));
        System.out.println(coinChangeV3(new int[]{2, 5}, 3));
        System.out.println(coinChangeV3(new int[]{1}, 3));
    }
}
