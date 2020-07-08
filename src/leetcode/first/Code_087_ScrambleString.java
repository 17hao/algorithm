package leetcode.first;

/**
 * 扰乱字符串
 * 状态方程定义：dp[i][j][k]表示S起始位i能否转成T起始位j长度k(长度zero based)
 * 状态转移方程：
 * dp[i][j][k] = dp[i][j][w] && dp[i+w][j+w][k-w](s1转成t1，s2转成t2)
 * dp[i][j][k] = dp[i][j+k-w][w] && dp[i+w][j][k-w](s1转成t2，s2转成t1)
 * 返回值：dp[0][0][字符串len]
 * 
 * @since 2020-7-8 Wednesday 15:01
 */
public class Code_087_ScrambleString {
    static boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] s = s1.toCharArray();
        char[] t = s2.toCharArray();
        int n = s.length;
        boolean[][][] dp = new boolean[n][n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = s[i] == t[j];
            }
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    for (int k = 1; k < len; k++) {
                        if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                        if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }

    public static void main(String[] args) {
        System.out.println(isScramble("great", "rgeat"));
        System.out.println(isScramble("abcde", "caebd"));
    }
}