package leetcode.third;

/**
 * 编辑距离
 * 状态方程定义：dp[i][j]为字符1前i个子串转为字符2前j个子串所需的最小步骤
 * 状态方程转移：dp[i][j] ::= if(s1[i]==s2[j]) dp[i][j] = dp[i-1][j-1]
 *  esle dp[i][j]=min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+1)
 * 初始化：dp[0][j] ::= j dp[i][0] ::= i
 * 结果：dp[i][j]
 * 
 * @since 2020-70-21 Tuesday 11:09 - 11：27
 */
public class Code_072_EditionDistance {
    static int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("word1", "word2"));
        System.out.println(minDistance("intention", "execution"));
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("", "ros"));
        System.out.println(minDistance("ros", ""));
    }
}