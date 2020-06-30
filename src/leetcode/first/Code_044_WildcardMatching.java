package leetcode.first;

/**
 * 通配符匹配
 * 方程定义：dp[m][n]: s1前m个字符是否匹配s2前n个字符
 * 初始值：dp[0][0] = true dp[0][i] = (dp[0][i - 1] && s2[i] == '*')
 * 状态转移方程：
 * - if (s1[i] == s2[j] || s2[j] == '?') dp[i][j] = dp[i - 1][j - 1]
 * - if (s2[j] == '*') dp[i][j] = (dp[i][j - 1](*匹配空字符串) || d[[i - 1][j](*匹配s1第i个字符))
 * 结果：dp[m][n]
 *
 * @since 2020-6-30 Tuesday 16:52
 */
public class Code_044_WildcardMatching {
    static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "*"));
    }
}
