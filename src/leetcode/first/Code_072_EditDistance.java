package leetcode.first;

/**
 * 编辑距离
 * <p>
 * dp[i][j]表示word1第i个之前的字符串转换成word2第j个之前的字符串需要的最小步骤,从第一个开始计数,0表示空字符串
 * 状态转移方程:
 * if (word1[i] == word2[j]) dp[i][j] = dp[i - 1][j - 1]
 * else dp[i][j] = min(dp[i - 1][j - 1](替换), dp[i - 1][j](删除), dp[i][j - 1](增加)) + 1
 * base case: dp[0][j] = j, dp[i][0] = i
 *
 * @since 2020-5-2 Saturday 10:51 - 11:10
 */
public class Code_072_EditDistance {
    static int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("", ""));
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
    }
}
