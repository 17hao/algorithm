package leetcode.second;

/**
 * 编辑距离
 * 动态规划
 * 状态方程定义: dp[i][j]是word1前i个字符(下标i之前的子串)转成word2前j个字符所需的最少步骤
 * if (word1[i] == word2[j]) dp[i][j] = dp[i - 1][j - 1]
 * else dp[i][j] = min(dp[i - 1][j](删除), d[[i][j - 1](插入), dp[i - 1][j - 1](更新)) + 1
 * <p>
 * 基础状态: dp[0][j] = j dp[i][0] = i
 *
 * @since 2020-6-11 Thursday 13:51
 */
public class Code_072_EditDistance {
    static int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("", "rose")); // 4
        System.out.println(minDistance("horse", "rose")); // 2
        System.out.println(minDistance("horse", "ros")); // 2
        System.out.println(minDistance("intention", "execution")); // 5
    }
}
