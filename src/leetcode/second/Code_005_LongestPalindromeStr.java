package leetcode.second;

/**
 * 找出一个字符串中最长的回文字符<br>
 * base case: dp[l][r] = false
 * 状态转移方程:dp[l][r] = s.charAt(l) == s.charAt(r) && ((l + 1) >= (r - 1) || dp[l + 1][r - 1])
 *
 * @since 11-23 Saturday
 */
public class Code_005_LongestPalindromeStr {
    static String longestPalindromeStr(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int len = s.length();
        String result = s.substring(0, 1);
        int lengthOfResult = 1;
        boolean[][] dp = new boolean[len][len];
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && ((r - l) <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if ((r - l + 1) > lengthOfResult) {
                        lengthOfResult = r - l + 1;
                        result = s.substring(l, r + 1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str1 = "abcefecbage";
        String str2 = "babad";
        String str3 = "ab";
        System.out.println(longestPalindromeStr(str2));
    }
}
