package leetcode.second;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * @since 2019-12-25 Wednesday 14:26 - 15:14
 */
public class Code_322_CoinChange {
    static int coinChangeV1(int[] coins, int amount) {
        if (amount == 0) return 0;
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin > amount) continue;
            int subPro = coinChangeV1(coins, amount - coin);
            if (subPro == -1) continue;
            result = Math.min(result, ++subPro);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    static int coinChangeV3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin > i) continue;
                dp[i] = Math.min(1 + dp[i - coin], dp[i]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        System.out.println(coinChangeV1(new int[]{1, 2, 5}, 35));
        System.out.println("time consumed: " + (System.currentTimeMillis() - start1) + " mills");
        long start2 = System.currentTimeMillis();
        System.out.println(coinChangeV1(new int[]{2, 6, 5}, 3));
        System.out.println("time consumed: " + (System.currentTimeMillis() - start2) + " mills");
        long start3 = System.currentTimeMillis();
        System.out.println(coinChangeV3(new int[]{1, 2, 5}, 35));
        System.out.println("time consumed: " + (System.currentTimeMillis() - start3) + " mills");
        long start4 = System.currentTimeMillis();
        System.out.println(coinChangeV3(new int[]{2, 6, 5}, 3));
        System.out.println("time consumed: " + (System.currentTimeMillis() - start4) + " mills");
    }
}

