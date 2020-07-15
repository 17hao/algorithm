package leetcode.first;

/**
 * s1和s2能否交错地构成s3
 * 问题定义：dp[i][j]为s1前i个字符和s2前j个字符能否构成s3前（i+j）个字符
 * 初始化：dp[0][j]为s2前j个字符能否组成s3前j个字符；dp[i][0]为s1前j个字符能否组成s3前j个字符
 * 状态转移方程：dp[i][j] = (dp[i][j - 1] && s2[j]==s3[j]) || (dp[i - 1][j] && s1[i]==s3[i])
 * 结果：dp[s1.len - 1][s2.len - 1]
 * 
 * @since 2020-7-15 Wednesday 18:25
 */
public class Code_097_InterleaveStrings {
    static boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if ((l1 + l2) != l3) {
            return false;
        }
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= l2; i++) {
            dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) || (dp[i - 1][j] && s1.charAt(i - 1)== s3.charAt(i + j- 1));
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("", "dbbca", "dbbca"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}