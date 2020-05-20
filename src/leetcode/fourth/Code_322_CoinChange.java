package leetcode.fourth;

import java.util.Arrays;

/**
 * 零钱兑换
 * 状态方程定义: dp[i]兑换i所需的最少硬币
 * dp[i] = min(dp[i - coin] + 1, dp[i]) | coin in coins[]
 * dp[0] = 0
 *
 * @since 2020-5-12 Tuesday 9:56
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
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // 用Integer.MAX_VALUE会导致溢出
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin > i) continue;
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChangeV2(new int[]{2, 5}, 3));
        System.out.println(coinChangeV2(new int[]{1, 2, 5}, 11));
        System.out.println(coinChangeV2(new int[]{1, 2, 5}, 38));
        // System.out.println(coinChangeV1(new int[]{2, 5}, 3));
        // System.out.println(coinChangeV1(new int[]{1, 2, 5}, 11));
        // System.out.println(coinChangeV1(new int[]{1, 2, 5}, 38));
    }
}
